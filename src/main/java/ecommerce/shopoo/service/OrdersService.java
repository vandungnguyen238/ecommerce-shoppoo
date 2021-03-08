package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Orders;
import ecommerce.shopoo.enumType.OrdersStatus;
import ecommerce.shopoo.objects.OrdersType;
import java.time.LocalDate;
import java.util.List;

public interface OrdersService {

    Orders getOrdersById(long ordersId);

    List<Orders> getAllOrders();

    void addOrders(Orders orders);

    void updateOrders(Orders orders);

    void deleteOrders(long ordersId);

    List<OrdersType> getOrdersByDate(LocalDate fromDate, LocalDate toDate);

    List<OrdersType> getOrdersByString(String keywords);

    List<OrdersType> getOrdersByID(long id);

    List<OrdersType> getStatusOrder(OrdersStatus ordersStatus);
    
    List<OrdersType> getMyOrders(String username);
}
