package ecommerce.shopoo.controller;

import ecommerce.shopoo.objects.OrdersType;
import ecommerce.shopoo.entity.Orders;
import ecommerce.shopoo.entity.Promotion;
import ecommerce.shopoo.entity.Shipping;
import ecommerce.shopoo.entity.Users;
import ecommerce.shopoo.enumType.OrdersStatus;
import ecommerce.shopoo.objects.DateToDate;
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
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ShippingService shippingService;

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private UsersService usersService;

    @RequestMapping(path = "/list")
    public String listAllOrder(HttpServletRequest request, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<Orders> list = ordersService.getAllOrders();
        String message = "Total: " + list.size() + " Orders. ";
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        return "order-list-page";
    }

    @RequestMapping(path = "/add")
    public String addOrders(Model model) {
        usersService.viewInfoUsersDetails(model);
        OrdersType ordersType = new OrdersType();
        List<OrdersStatus> ordersStatusList = new ArrayList<>();
        ordersStatusList.add(OrdersStatus.pending);
        ordersStatusList.add(OrdersStatus.received);
        ordersStatusList.add(OrdersStatus.shipping);
        ordersStatusList.add(OrdersStatus.shipped);
        List<Shipping> shippingList = (List<Shipping>) shippingService.getAllShipping();
        List<Promotion> promotionList = (List<Promotion>) promotionService.getAllPromotion();
        List<Users> usersList = (List<Users>) usersService.getAllUsers();
        model.addAttribute("ordersType", ordersType);
        model.addAttribute("shippingList", shippingList);
        model.addAttribute("promotionList", promotionList);
        model.addAttribute("usersList", usersList);
        model.addAttribute("ordersStatusList", ordersStatusList);
        model.addAttribute("type", "add");
        return "order-addForm-page";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveOrders(@ModelAttribute OrdersType ordersType, Orders orders, Model model) {
        usersService.viewInfoUsersDetails(model);
        Shipping shipping = shippingService.getShippingById(ordersType.getShippingId());
        Promotion promotion = promotionService.getPromotionById(ordersType.getPromotionId());
        Users users = usersService.getUsersById(ordersType.getUsersId());
        orders.setId(ordersType.getId());
        orders.setTotal(ordersType.getTotal());
        orders.setShipping(shipping);
        orders.setPromotion(promotion);
        orders.setUsers(users);
        orders.setOrdersStatus(ordersType.getOrdersStatus());
        ordersService.addOrders(orders);
        return "redirect:/orders/list";
    }

    @RequestMapping("/edit")
    public String updateOrders(@RequestParam("id") long id, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<OrdersStatus> ordersStatusList = new ArrayList<>();
        ordersStatusList.add(OrdersStatus.pending);
        ordersStatusList.add(OrdersStatus.received);
        ordersStatusList.add(OrdersStatus.shipping);
        ordersStatusList.add(OrdersStatus.shipped);
        List<Shipping> shippingList = shippingService.getAllShipping();
        List<Promotion> promotionList = promotionService.getAllPromotion();
        List<Users> usersList = usersService.getAllUsers();
        Orders orders = ordersService.getOrdersById(id);
        OrdersType ordersType = new OrdersType();
        ordersType.setId(id);
        ordersType.setFullName(orders.getUsers().getFullName());
        ordersType.setCreateDate(orders.getCreateDate());
        ordersType.setAddress(orders.getUsers().getAddress());
        ordersType.setPhone(orders.getUsers().getPhone());
        ordersType.setEmail(orders.getUsers().getEmail());
        ordersType.setTotal(orders.getTotal());
        ordersType.setDiscount(orders.getPromotion().getDiscount());
        ordersType.setCost(orders.getShipping().getCost());

        model.addAttribute("ordersType", ordersType);
        model.addAttribute("orders", orders);
        model.addAttribute("shippingList", shippingList);
        model.addAttribute("promotionList", promotionList);
        model.addAttribute("usersList", usersList);
        model.addAttribute("ordersStatusList", ordersStatusList);
        model.addAttribute("type", "edit");
        return "order-editForm-page";
    }

    @RequestMapping("/delete")
    public String deleteOrders(@RequestParam("id") long id, Model model) {
        usersService.viewInfoUsersDetails(model);
        ordersService.deleteOrders(id);
        return "redirect:/orders/list";
    }

    @RequestMapping(path = "/searchByID")
    public String searchOrdersById(@RequestParam long id, Model model) {
        usersService.viewInfoUsersDetails(model);
        Orders orders = ordersService.getOrdersById(id);
        List<Orders> list = new ArrayList<>();
        if (orders != null) {
            list.add(orders);
        }
        String message;
        if (list.size() > 0) {
            message = "\t Tim thay " + list.size() + " Orders";
        } else {
            message = "\t Khong tim thay";
        }
        model.addAttribute("list", list);
        model.addAttribute("message", message);
        model.addAttribute("id", id);
        return "order-list-page";
    }

    @RequestMapping(path = "/searchByTool")
    public String searchOrdersByTool(Model model) {
        usersService.viewInfoUsersDetails(model);
        DateToDate dateToDate = new DateToDate();
        dateToDate.setFromDate(dateToDate.getCurrentDate());
        dateToDate.setToDate(dateToDate.getCurrentDate());
        model.addAttribute("dateToDate", dateToDate);
        return "order-searchByTool-page";
    }

    @RequestMapping(path = "/searchByText")
    public String searchOrdersByText(@RequestParam("keywords") String keywords, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<OrdersType> list = ordersService.getOrdersByString(keywords);
        if (list.size() > 0) {
            model.addAttribute("message", "\t Tim thay " + list.size() + " Orders");
        } else {
            model.addAttribute("message", "\t Khong tim thay");
        }
        DateToDate dateToDate = new DateToDate();
        dateToDate.setFromDate(dateToDate.getCurrentDate());
        dateToDate.setToDate(dateToDate.getCurrentDate());
        model.addAttribute("dateToDate", dateToDate);
        model.addAttribute("list", list);
        model.addAttribute("keywords", keywords);
        return "order-searchByTool-page";
    }

    @RequestMapping(path = "/searchDateToDate")
    public String searchOrdersByDate(@ModelAttribute DateToDate dateToDate, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<OrdersType> list = ordersService.getOrdersByDate(dateToDate.getFromDate(), dateToDate.getToDate());
        model.addAttribute("list", list);
        model.addAttribute("message", " Tìm thấy " + list.size() + " Orders");
        model.addAttribute("fromDate", dateToDate.getFromDate());
        model.addAttribute("toDate", dateToDate.getToDate());
        return "order-searchByTool-page";
    }

    @RequestMapping(path = "/searchOrderStatus")
    public String SearchOrderStatus(@RequestParam OrdersStatus ordersStatus, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<OrdersType> list = ordersService.getStatusOrder(ordersStatus);
        model.addAttribute("list", list);
        DateToDate dateToDate = new DateToDate();
        dateToDate.setFromDate(dateToDate.getCurrentDate());
        dateToDate.setToDate(dateToDate.getCurrentDate());
        model.addAttribute("dateToDate", dateToDate);
        return "order-searchByTool-page";
    }

    @RequestMapping(path = "/myOrder")
    public String myOrders(@RequestParam String username, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<OrdersType> list = ordersService.getMyOrders(username);
        model.addAttribute("list", list);
        DateToDate dateToDate = new DateToDate();
        dateToDate.setFromDate(dateToDate.getCurrentDate());
        dateToDate.setToDate(dateToDate.getCurrentDate());
        model.addAttribute("dateToDate", dateToDate);
        return "order-searchByTool-page";
    }

    @RequestMapping(path = "/report")
    public String report(Model model) {
        usersService.viewInfoUsersDetails(model);
        DateToDate dateToDate = new DateToDate();
        dateToDate.setFromDate(dateToDate.getCurrentDate());
        dateToDate.setToDate(dateToDate.getCurrentDate());
        model.addAttribute("dateToDate", dateToDate);
        return "report-summary-page";
    }

    @RequestMapping(path = "/reportSummary")
    public String reportSummary(@ModelAttribute DateToDate dateToDate, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<OrdersType> list = ordersService.getOrdersByDate(dateToDate.getFromDate(), dateToDate.getToDate());
        double total = 0;
        for (OrdersType o : list) {
            total += o.getTotal();
        }
        model.addAttribute("number", list.size());
        model.addAttribute("total", total);
        model.addAttribute("fromDate", dateToDate.getFromDate());
        model.addAttribute("toDate", dateToDate.getToDate());
        return "report-summary-page";
    }
}
