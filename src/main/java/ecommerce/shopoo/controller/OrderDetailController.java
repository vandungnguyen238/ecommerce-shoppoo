package ecommerce.shopoo.controller;

import ecommerce.shopoo.entity.OrderDetail;
import ecommerce.shopoo.objects.OrdersType;
import ecommerce.shopoo.entity.Orders;
import ecommerce.shopoo.entity.Promotion;
import ecommerce.shopoo.entity.Shipping;
import ecommerce.shopoo.entity.Users;
import ecommerce.shopoo.enumType.OrdersStatus;
import ecommerce.shopoo.objects.DateToDate;
import ecommerce.shopoo.objects.OrderDetailType;
import ecommerce.shopoo.service.OrderDetailService;
import ecommerce.shopoo.service.OrdersService;
import ecommerce.shopoo.service.PromotionService;
import ecommerce.shopoo.service.ShippingService;
import ecommerce.shopoo.service.UsersService;
import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private UsersService usersService;

    @RequestMapping(path = "/list")
    public String allOrderDetail(Model model) {
        usersService.viewInfoUsersDetails(model);
        List<OrderDetail> list = orderDetailService.getAllOrderDetail();
        String message = "Total: " + list.size() + " Orders. ";
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        return "orderDetail-page";
    }

    @RequestMapping(path = "/getOrderDetailByOrderId")
    public String getOrderDetailByOrderId(@RequestParam Long id, Model model) throws Exception{
        usersService.viewInfoUsersDetails(model);
        List<OrderDetail> list = orderDetailService.getOrderDetailByOrdersID(id);
        String message = "Total: " + list.size() + " Products ";
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        return "orderDetail-page";
    }


}
