package ecommerce.shopoo.controller;

import ecommerce.shopoo.entity.Shipping;
import ecommerce.shopoo.objects.DateToDate;
import ecommerce.shopoo.service.ShippingService;
import ecommerce.shopoo.service.UsersService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shipping")
public class ShippingController {
    @Autowired
    private ShippingService shippingService;
    
    @Autowired
    private UsersService usersService;
    
    @GetMapping(path = "/list")
    public String listAllShipping(HttpServletRequest request, Model model){
        usersService.viewInfoUsersDetails(model);
        List<Shipping> list = shippingService.getAllShipping();
        String message = "Total: " + list.size() + " Shipping. ";
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        return "form-list-shipping-page";
    }
    
    @RequestMapping(path = "/add")
    public String addShipping(Model model){
        usersService.viewInfoUsersDetails(model);
        Shipping shipping = new Shipping();
        model.addAttribute("shipping", shipping);
        model.addAttribute("type", "add");
        return "form-add-shipping-page";
    }
    
    @PostMapping("/save")
    public String saveShipping(@ModelAttribute("shipping") Shipping shipping, Model model) {
        usersService.viewInfoUsersDetails(model);
        shipping.setId(shipping.getId());
        shipping.setShippingName(shipping.getShippingName());
        shipping.setWarehouse(shipping.getWarehouse());
        shipping.setReceivedBy(shipping.getReceivedBy());
        shipping.setDescription(shipping.getDescription());
        shipping.setOrdersStatus(shipping.getOrdersStatus());
        shipping.setShippingStatus(shipping.getShippingStatus());
        shipping.setReceivedDate(shipping.getReceivedDate());
        shipping.setShipDate(shipping.getShipDate());
        shippingService.addShipping(shipping);
	return "redirect:/shipping/list";
    }
    
    @GetMapping("/update")
    public String updateShipping(@RequestParam("id") long id, Model model) {
        usersService.viewInfoUsersDetails(model);
	Shipping shipping = shippingService.getShippingById(id);
        shipping.setId(shipping.getId());
        shipping.setShippingName(shipping.getShippingName());
        shipping.setWarehouse(shipping.getWarehouse());
        shipping.setReceivedBy(shipping.getReceivedBy());
        shipping.setDescription(shipping.getDescription());
        shipping.setOrdersStatus(shipping.getOrdersStatus());
        shipping.setShippingStatus(shipping.getShippingStatus());
        shipping.setReceivedDate(shipping.getReceivedDate());
        shipping.setShipDate(shipping.getShipDate());
	model.addAttribute("shipping", shipping);
	return "form-add-shipping-page";
    }
    
    @GetMapping("/delete")
    public String deleteShipping(@RequestParam("id") long id, Model model) {
        usersService.viewInfoUsersDetails(model);
	shippingService.deleteShipping(id);
	return "redirect:/shipping/list";
    }
    
    @GetMapping(path = "/searchByID")
    public String searchShippingById(@RequestParam long id, Model model) {
        usersService.viewInfoUsersDetails(model);
        Shipping shipping = shippingService.getShippingById(id);
        List<Shipping> list = new ArrayList<>();
        if (shipping != null) {
            list.add(shipping);
        }
        String message;
        if (list.size() > 0) {
            message = "\t Tim thay " + list.size() + " Shipping";
        } else {
            message = "\t Khong tim thay";
        }
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        return "form-search-shipping-page";
    }
    
    @GetMapping(path = "/searchByText")
    public String searchShippingByText(@RequestParam String keywords, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<Shipping> list = shippingService.getShippingByKeyword(keywords);
        String message;
        if (list.size() > 0) {
            message = "\t Tim thay " + list.size() + " Shipping";
        } else {
            message = "\t Khong tim thay";
        }
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        return "form-search-shipping-freetext-page";
    }
    
    @GetMapping(path = "/searchByTool")
    public String searchShippingByTool(Model model) {
        usersService.viewInfoUsersDetails(model);
        List<Shipping> list = shippingService.getAllShipping();
        String message = "Total: " + list.size() + " Shipping. ";
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        return "form-search-shipping-page";
    }
    
    @GetMapping(path = "/getByShippingName")
    public String getByShippingName(@RequestParam String name, Model model) {
        usersService.viewInfoUsersDetails(model);
        Shipping shipping = shippingService.getByShippingName(name);
        model.addAttribute("shipping", shipping);
        return "shipping-detail-page";
    }
}
