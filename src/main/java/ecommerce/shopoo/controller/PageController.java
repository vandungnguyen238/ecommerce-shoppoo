package ecommerce.shopoo.controller;

import ecommerce.shopoo.entity.Products;
import ecommerce.shopoo.service.OrdersService;
import ecommerce.shopoo.service.ProductsService;
import ecommerce.shopoo.service.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UsersService usersService;

    @RequestMapping(path = "/home")
    public String viewHomePage(Model model) {
        usersService.insertData();
        usersService.viewInfoUsersDetails(model);
        List<Products> list = productsService.getProductByUpdateDate();
        model.addAttribute("list", list);
        return "homepage";
    }

    @RequestMapping(path = "/homepage")
    public String homePage(Model model) {
        return "redirect:/home";
    }

    @RequestMapping(path = "/contact")
    public String contactPage(Model model) {
        usersService.viewInfoUsersDetails(model);
        return "contact-page";
    }

    
    
}
