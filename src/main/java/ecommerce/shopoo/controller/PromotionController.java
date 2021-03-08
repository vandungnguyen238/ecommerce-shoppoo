package ecommerce.shopoo.controller;

import ecommerce.shopoo.entity.Promotion;
import ecommerce.shopoo.service.PromotionService;
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
@RequestMapping("/promotion")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;
    
    @Autowired
    private UsersService usersService;
    
    @GetMapping(path = "/list")
    public String listAllPromotion(HttpServletRequest request, Model model){
        usersService.viewInfoUsersDetails(model);
        List<Promotion> list = promotionService.getAllPromotion();
        String message = "Total: " + list.size() + " Promotion. ";
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        return "form-list-promotion-page";
    }
    
    @RequestMapping(path = "/add")
    public String addPromotion(Model model){
        usersService.viewInfoUsersDetails(model);
        Promotion promotion = new Promotion();
        model.addAttribute("promotion", promotion);
        model.addAttribute("type", "add");
        return "form-add-promotion-page";
    }
    
    @PostMapping("/save")
    public String savePromotion(@ModelAttribute("promotion") Promotion promotion, Model model) {
        usersService.viewInfoUsersDetails(model);
        promotion.setId(promotion.getId());
        promotion.setName(promotion.getName());
        promotion.setStartDate(promotion.getStartDate());
        promotion.setEndDate(promotion.getEndDate());
        promotion.setDiscount(promotion.getDiscount());
        promotionService.addPromotion(promotion);
	return "redirect:/promotion/list";
    }
    
    @GetMapping("/update")
    public String updatePromotion(@RequestParam("id") long id,
	    Model model) {
        usersService.viewInfoUsersDetails(model);
	Promotion promotion = promotionService.getPromotionById(id);
        promotion.setId(promotion.getId());
        promotion.setName(promotion.getName());
        promotion.setStartDate(promotion.getStartDate());
        promotion.setEndDate(promotion.getEndDate());
        promotion.setDiscount(promotion.getDiscount());
	model.addAttribute("promotion", promotion);
	return "form-add-promotion-page";
    }
    
    @GetMapping("/delete")
    public String deletePromotion(@RequestParam("id") long id, Model model) {
        usersService.viewInfoUsersDetails(model);
	promotionService.deletePromotion(id);
	return "redirect:/promotion/list";
    }
    
    @GetMapping(path = "/searchByID")
    public String searchPromotionById(@RequestParam long id, Model model) {
        usersService.viewInfoUsersDetails(model);
        Promotion promotion = promotionService.getPromotionById(id);
        List<Promotion> list = new ArrayList<>();
        if (promotion != null) {
            list.add(promotion);
        }
        String message;
        if (list.size() > 0) {
            message = "\t Tim thay " + list.size() + " Promotion";
        } else {
            message = "\t Khong tim thay";
        }
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        return "form-list-promotion-page";
    }
    
    @GetMapping(path = "/searchByText")
    public String searchPromotionByText(@RequestParam String keywords, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<Promotion> list = promotionService.getPromotionByKeyword(keywords);
        String message;
        if (list.size() > 0) {
            message = "\t Tim thay " + list.size() + " Promotion";
        } else {
            message = "\t Khong tim thay";
        }
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        return "form-list-promotion-page";
    }
}
