package ecommerce.shopoo.controller;

import java.time.LocalDate;
import java.util.List;
import ecommerce.shopoo.entity.Orders;
import ecommerce.shopoo.entity.OrderDetail;
import ecommerce.shopoo.entity.Products;
import ecommerce.shopoo.entity.Promotion;
import ecommerce.shopoo.entity.Shipping;
import ecommerce.shopoo.entity.Users;
import ecommerce.shopoo.enumType.OrdersStatus;
import ecommerce.shopoo.javaMail.SendLinkCheckout;
import ecommerce.shopoo.objects.LineItem;
import ecommerce.shopoo.objects.OrdersType;
import ecommerce.shopoo.service.OrderDetailService;
import ecommerce.shopoo.service.OrdersService;
import ecommerce.shopoo.service.ProductsService;
import ecommerce.shopoo.service.PromotionService;
import ecommerce.shopoo.service.ShippingService;
import ecommerce.shopoo.service.UsersService;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/checkout")
public class CheckoutController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private ShippingService shippingService;

    @Autowired
    private PromotionService promotionService;

    @RequestMapping(path = "/detail")
    public String checkout(HttpSession session, Model model) {
        usersService.viewInfoUsersDetails(model);
        LocalDate currentDate = LocalDate.now();
        OrdersType ordersType = new OrdersType();
        List<Shipping> shippingList = shippingService.getAllShipping();
        List<Promotion> promotionList = promotionService.getAllPromotion();
        model.addAttribute("currentDate", currentDate);
        model.addAttribute("shippingList", shippingList);
        model.addAttribute("promotionList", promotionList);
        model.addAttribute("ordersType", ordersType);
        return "checkout-page";
    }

    @RequestMapping(path = "/changeShipping")
    public String changeShipping(@RequestParam long id, HttpSession session, Model model) {
        usersService.viewInfoUsersDetails(model);
        LocalDate currentDate = LocalDate.now();
        OrdersType ordersType = new OrdersType();
        ordersType.setShippingId(id);
        ordersType.setShippingName(shippingService.getShippingById(id).getShippingName());
        ordersType.setCost(shippingService.getShippingById(id).getCost());

        List<Shipping> shippingList = shippingService.getAllShipping();
        List<Promotion> promotionList = promotionService.getAllPromotion();
        model.addAttribute("currentDate", currentDate);
        model.addAttribute("shippingList", shippingList);
        model.addAttribute("promotionList", promotionList);
        model.addAttribute("ordersType", ordersType);
        return "checkout-page";
    }

    @PostMapping("/save")
    public String saveOrders(@ModelAttribute OrdersType ordersType, HttpSession session, Model model) throws Exception {
        usersService.viewInfoUsersDetails(model);
        List<Products> productsList = productsService.getAllProducts();
        Users users = usersService.getUsersByAuthentication();
        Shipping shipping = shippingService.getShippingById(ordersType.getShippingId());
        Promotion promotion = promotionService.getPromotionById(ordersType.getPromotionId());
        Orders orders = new Orders();
        orders.setUsers(users);
        orders.setShipping(shipping);
        orders.setPromotion(promotion);
        orders.setTotal(ordersType.getTotal());
        ordersService.addOrders(orders);
        SendLinkCheckout.sendMailTo(users.getEmail(), orders.getId());

        @SuppressWarnings("unchecked")
        List<LineItem> lineItems = (List<LineItem>) session.getAttribute("lineItems");
        for (LineItem item : lineItems) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrders(orders);
            orderDetail.setProducts(item.getProducts());
            orderDetail.setQuantity(item.getQuantity());
            orderDetail.setAmount(item.getQuantity() * item.getProducts().getUnitPrice());
            orderDetailService.addOrderDetail(orderDetail);
        }

        model.addAttribute("message", "Please check mail confirm");
        model.addAttribute("list", productsList);
        return "homepage";
    }

    @RequestMapping(path = "/confirm")
    public String confirmPlaceOrder(@RequestParam("id") long id, HttpSession session, Model model) throws Exception {
        usersService.viewInfoUsersDetails(model);
        List<Products> productsList = productsService.getAllProducts();
        Users users = usersService.getUsersByAuthentication();
        Orders orders = ordersService.getOrdersById(id);
        orders.setOrdersStatus(OrdersStatus.received);
        ordersService.addOrders(orders);
//        List<LineItem> lineItems = (List<LineItem>) session.getAttribute("lineItems");
//        for (LineItem item : lineItems) {
//            OrderDetail orderDetail = new OrderDetail();
//            orderDetail.setOrders(orders);
//            orderDetail.setProducts(item.getProducts());
//            orderDetail.setQuantity(item.getQuantity());
//            orderDetail.setAmount(item.getQuantity() * item.getProducts().getUnitPrice());
//            orderDetailService.addOrderDetail(orderDetail);
//        }
//        List<LineItem> lineItems = (List<LineItem>) session.getAttribute("lineItems");
//        List<Products> productList = new ArrayList<>();
//        List<Integer> quantityList = new ArrayList<>();
//        for (LineItem item : lineItems) {
//            productList.add(productsService.getProductsById(item.getProducts().getId()));
//            quantityList.add(item.getQuantity());
//        }
//        int count = 0;
//        for (Products p : productList) {
//            OrderDetail orderDetail = new OrderDetail();
//            orderDetail.setOrders(orders);
//            orderDetail.setProducts(p);
//            for (int i = count; i < quantityList.size(); i++) {
//                orderDetail.setQuantity(quantityList.get(i));
//                orderDetail.setAmount(p.getUnitPrice() * quantityList.get(i));
//                orderDetailService.addOrderDetail(orderDetail);
//                count++;
//                break;
//            }
//        }
        model.addAttribute("message", "Order was confirmed. Shop will send product to you as soon as possible.");
        model.addAttribute("list", productsList);
        return "homepage";
    }
}
