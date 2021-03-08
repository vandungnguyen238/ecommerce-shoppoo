package ecommerce.shopoo.controller;

import ecommerce.shopoo.entity.Roles;
import ecommerce.shopoo.entity.Users;
import ecommerce.shopoo.entity.UsersRoles;
import ecommerce.shopoo.javaMail.SendLinkRegister;
import ecommerce.shopoo.javaMail.JavaMailUtil;
import ecommerce.shopoo.objects.DateToDate;
import ecommerce.shopoo.service.RolesService;
import ecommerce.shopoo.service.UsersRolesService;
import ecommerce.shopoo.service.UsersService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersRolesService usersRolesService;

    @Autowired
    private RolesService rolesService;

    //Check info my account ====================================================
    @RequestMapping(value = "/myAccount")
    public String viewAccountDetail(Model model) {
        usersService.viewInfoUsersDetails(model);
        return "account-detail-page";
    }

    //===========   View List Account - CRUD ===================================
    @RequestMapping(value = "/list")
    public String list(Model model) {
        usersService.viewInfoUsersDetails(model);
        List<Users> list = usersService.getAllUsers();
        String message = "Total: " + list.size() + " Users. ";
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        return "account-list-page";
    }

    @RequestMapping(path = "/add")
    public String addUsers(Users users, String message, Model model) {
        usersService.viewInfoUsersDetails(model);
        model.addAttribute("users", users);
        model.addAttribute("type", "add");
        model.addAttribute("message", message);
        return "account-updateForm-page";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveAccount(@Valid @ModelAttribute("users") Users users,
            BindingResult result, Model model) throws Exception {

        usersService.viewInfoUsersDetails(model);
        if (result.hasErrors()) {
            if (users.getId() > 0) {
                model.addAttribute("type", "edit");
            } else {
                model.addAttribute("type", "add");
            }
            return "account-updateForm-page";

        } else {
            //if new username -> existing
            if (users.getId() == 0) {
                if (usersService.existingUsername(users.getUsername())) {
                    model.addAttribute("message", "Username is existing");
                    model.addAttribute("users", users);
                    return "account-updateForm-page";
                }
            }

            //if password # confirmPassword
            if (!(users.getPassword().equals(users.getConfirmPassword()))) {
                model.addAttribute("message", "Infomation is not valid");
                if (users.getId() > 0) {
                    //edit must have param id
                    model.addAttribute("id", users.getId());
                    return "redirect:/account/edit";
                }
                model.addAttribute("users", users);
                return "redirect:/account/add";
            } else {
                //save info
                users.setFullName(users.getFirstName() + " " + users.getLastName());
                usersService.addUsers(users);
                //Set new User -> ROLE_GUEST
                if (usersService.getUsersByUserName(users.getUsername()).isEnable() == false) {
                    Roles roles = rolesService.getRolesById(3);
                    UsersRoles usersRoles = new UsersRoles();
                    usersRoles.setUsers(users);
                    usersRoles.setRoles(roles);
                    usersRolesService.addUsersRoles(usersRoles);
                    SendLinkRegister.sendMailTo(users.getEmail(), users.getId());
                    //Save before --> co the users.getId()
                }
            }

            model.addAttribute("list", usersService.getAllUsers());
            model.addAttribute("message", "Update successfully!");
            return "account-list-page";

        }
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editAccount(@RequestParam long id, String message, Model model) {
        usersService.viewInfoUsersDetails(model);
        Users users = usersService.getUsersById(id);
        users.setPassword("oldPassword");
        model.addAttribute("users", users);
        model.addAttribute("type", "edit");
        model.addAttribute("message", message);
        return "account-updateForm-page";
    }

    @GetMapping(path = "/delete")
    public String deleteAccount(@RequestParam long id) {
        List<UsersRoles> usersRolesList = usersRolesService.getUsersRolesByUsers(usersService.getUsersById(id));
        for (UsersRoles usersRoles : usersRolesList) {
            usersRolesService.deleteUsersRoles(usersRoles.getId());
        }
        usersService.deleteUsers(id);
        return "redirect:/account/list";
    }

    @GetMapping(path = "/searchByID")
    public String searchById(@RequestParam long id, Model model) {
        usersService.viewInfoUsersDetails(model);
        Users users = usersService.getUsersById(id);
        List<Users> list = new ArrayList<>();
        String message;
        if (users != null) {
            list.add(users);
            message = " Tìm thấy " + list.size() + " User";
        } else {
            message = " Không tìm thấy";
        }
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        return "account-list-page";
    }

    @RequestMapping(path = "/searchByName")
    public String searchByName(@RequestParam String name, Model model) {
        List<Users> list = usersService.getUsersByString(name);
        String message;
        if (list.size() > 0) {
            message = " Tìm thấy " + list.size() + " User";
        } else {
            message = " Không tìm thấy";
        }
        DateToDate dateToDate = new DateToDate();
        dateToDate.setFromDate(dateToDate.getCurrentDate());
        dateToDate.setToDate(dateToDate.getCurrentDate());
        model.addAttribute("dateToDate", dateToDate);
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        model.addAttribute("name", name);
        return "account-searchByTool-page";
    }

    @RequestMapping(path = "/searchByTool")
    public String searchAccountByTool(Model model) {
        usersService.viewInfoUsersDetails(model);

        DateToDate dateToDate = new DateToDate();
        dateToDate.setFromDate(dateToDate.getCurrentDate());
        dateToDate.setToDate(dateToDate.getCurrentDate());
        model.addAttribute("dateToDate", dateToDate);
        return "account-searchByTool-page";
    }

    @GetMapping(path = "/searchNewAccount")
    public String searchNewAccount(Model model) {
        usersService.viewInfoUsersDetails(model);
        List<Users> list = usersService.getNewUsers();
        String message = " Tìm thấy " + list.size() + " Account";

        DateToDate dateToDate = new DateToDate();
        dateToDate.setFromDate(dateToDate.getCurrentDate());
        dateToDate.setToDate(dateToDate.getCurrentDate());
        model.addAttribute("dateToDate", dateToDate);
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        return "account-searchByTool-page";
    }

    //do not use Post Method =============================================
    @GetMapping(path = "/searchByDate")
    public String searchAccountByDate(@ModelAttribute DateToDate dateToDate, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<Users> list = usersService.getUsersByDate(dateToDate.getFromDate(), dateToDate.getToDate());
        String message = " Tìm thấy " + list.size() + " Account";
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        model.addAttribute("fromDate", dateToDate.getFromDate());
        model.addAttribute("toDate", dateToDate.getToDate());
        return "account-searchByTool-page";
    }

//    @GetMapping(path = "/searchbyDate")
//    public String searchAccountByDate(@RequestParam("fromDate") LocalDate fromDate, 
//            @RequestParam("toDate") LocalDate toDate, Model model) {
//        usersService.viewInfoUsersDetails(model);
//        List<Users> list = usersService.getUsersByDate(fromDate, toDate);
//        String message = " Tìm thấy " + list.size() + " Account";
//        model.addAttribute("list", list);
//        model.addAttribute("message", message);
//        return "account-searchByTool-page";
//    }
    @RequestMapping(path = "/insertData")
    public String insertDataToProject() {
        usersService.insertData();
        return "redirect:/account/list";
    }
}
