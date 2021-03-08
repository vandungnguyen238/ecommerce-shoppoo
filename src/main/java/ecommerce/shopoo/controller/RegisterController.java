package ecommerce.shopoo.controller;

import ecommerce.shopoo.entity.Roles;
import ecommerce.shopoo.entity.Users;
import ecommerce.shopoo.entity.UsersRoles;
import ecommerce.shopoo.javaMail.SendLinkRegister;
import ecommerce.shopoo.service.RolesService;
import ecommerce.shopoo.service.UsersRolesService;
import ecommerce.shopoo.service.UsersService;
import java.time.LocalDate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersRolesService usersRolesService;

    @Autowired
    private RolesService rolesService;

    //Register account ========================================================
    @RequestMapping(path = "/register")
    public String registerAccount(Model model) {
        Users users = new Users();
        model.addAttribute("users", users);
        return "account-register-page";
    }

    @RequestMapping(path = "/process", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute Users users, BindingResult result, Model model) throws Exception {
        usersService.viewInfoUsersDetails(model);
        if (result.hasErrors()) {
            return "account-register-page";
        }
        //if new username -> existing
        if (users.getId() == 0) {
            if (usersService.existingUsername(users.getUsername())) {
                model.addAttribute("message", "Username is existing");
                model.addAttribute("users", users);
                return "account-register-page";
            }
        }
        //if password # confirmPassword
        if (!users.getPassword().equals(users.getConfirmPassword())) {
            model.addAttribute("message", " Passwords are not same");
            model.addAttribute("users", users);
            return "account-register-page";
        }
        //save info
        users.setFullName(users.getFirstName() + " " + users.getLastName());
        //Save before --> co the users.getId()
        usersService.addUsers(users);
        //Set new User -> ROLE_GUEST
        if (usersService.getUsersByUserName(users.getUsername()).isEnable() == false) {
            Roles roles = rolesService.getRolesById(3);
            UsersRoles usersRoles = new UsersRoles();
            usersRoles.setUsers(users);
            usersRoles.setRoles(roles);
            usersRolesService.addUsersRoles(usersRoles);
        }
        //JavaMailUtil.sendMailTo("aodaivietnam000@gmail.com");
        //SendLinkRegister.sendMailTo("aodaivietnam000@gmail.com");
        SendLinkRegister.sendMailTo(users.getEmail(), users.getId());
        model.addAttribute("message", " Đăng ký thành công. Vui lòng kiểm tra email để kích hoạt");
        return "homepage";
    }

    //Enable Account
    @RequestMapping(path = "/setEnableTrue")
    public String setTrueForEnable(@RequestParam long id, Model model) {
        Users users = usersService.getUsersById(id);
        users.setEnable(true);//Set enable=true -->Tai khoan customer duoc kich hoat
        usersService.addUsers(users);
        Roles roles = rolesService.getRolesById(2); //Set ROLE_USER
        UsersRoles usersRoles = new UsersRoles();
        usersRoles.setUsers(users);
        usersRoles.setRoles(roles);
        usersRolesService.addUsersRoles(usersRoles);
        model.addAttribute("message", "Cảm ơn bạn đã xác nhận, tài khoản được kích hoạt thành công.");
        model.addAttribute("users", users);
        return "homepage";
    }
}
