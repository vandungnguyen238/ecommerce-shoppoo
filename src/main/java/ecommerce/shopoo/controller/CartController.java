package ecommerce.shopoo.controller;

import ecommerce.shopoo.objects.LineItem;
import ecommerce.shopoo.service.ProductsService;
import ecommerce.shopoo.service.UsersService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private ProductsService productsService;

    @RequestMapping(path = "/cart")
    public String cartPage(Model model) {
        usersService.viewInfoUsersDetails(model);
        return "cart-page";
    }

    @RequestMapping(path = "/cart/add/{id}")
    public String addToCart(@PathVariable("id") Long id, HttpSession session, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<LineItem> lineItems = (List<LineItem>) session.getAttribute("lineItems");
        if (session.getAttribute("lineItems") == null) {
            lineItems = new ArrayList<>();
            lineItems.add(new LineItem(productsService.getProductsById(id), 1));
            session.setAttribute("lineItems", lineItems);
        } else {
            int index = isExisting(id, session);
            if (index == -1) {
                lineItems.add(new LineItem(productsService.getProductsById(id), 1));
            } else {
                int quantity = lineItems.get(index).getQuantity() + 1;
                lineItems.get(index).setQuantity(quantity);
            }
            session.setAttribute("lineItems", lineItems);
        }
        return "redirect:/products/list";
    }

    @RequestMapping(path = "/cart/buy/{id}")
    public String buyNow(@PathVariable("id") Long id, HttpSession session, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<LineItem> lineItems = (List<LineItem>) session.getAttribute("lineItems");
        if (session.getAttribute("lineItems") == null) {
            lineItems = new ArrayList<>();
            lineItems.add(new LineItem(productsService.getProductsById(id), 1));
            session.setAttribute("lineItems", lineItems);
        } else {
            int index = isExisting(id, session);
            if (index == -1) {
                lineItems.add(new LineItem(productsService.getProductsById(id), 1));
            } else {
                int quantity = lineItems.get(index).getQuantity() + 1;
                lineItems.get(index).setQuantity(quantity);
            }
            session.setAttribute("lineItems", lineItems);
        }
        return "cart-page";
    }

    @RequestMapping(path = "/cart/remove/{id}")
    public String removeLineItem(@PathVariable("id") Long id, HttpSession session, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<LineItem> lineItems = (List<LineItem>) session.getAttribute("lineItems");
        lineItems.remove(isExisting(id, session));
        return "cart-page";
    }

    private int isExisting(long id, HttpSession session) {
        List<LineItem> lineItems = (List<LineItem>) session.getAttribute("lineItems");
        int index = 0;
        for (LineItem item : lineItems) {
            if (item.getProducts().getId() == id) {
                return index; //return vi tri trong list
            }
            index++;
        }
        return -1;
    }

    @RequestMapping(path = "/cart/increate/{index}")
    public String increateQuantity(@PathVariable("index") Integer index, HttpSession session, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<LineItem> lineItems = (List<LineItem>) session.getAttribute("lineItems");
        int quantity = lineItems.get(index).getQuantity() + 1;
        lineItems.get(index).setQuantity(quantity);
        session.setAttribute("lineItems", lineItems);
        return "cart-page";
    }

    @RequestMapping(path = "/cart/decreate/{index}")
    public String decreateQuantity(@PathVariable("index") Integer index, HttpSession session, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<LineItem> lineItems = (List<LineItem>) session.getAttribute("lineItems");
        if (lineItems.get(index).getQuantity() > 1) {
            int quantity = lineItems.get(index).getQuantity() - 1;
            lineItems.get(index).setQuantity(quantity);
            session.setAttribute("lineItems", lineItems);
        }
        return "cart-page";
    }

}
