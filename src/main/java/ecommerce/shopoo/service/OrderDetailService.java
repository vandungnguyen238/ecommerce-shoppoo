package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.OrderDetail;
import ecommerce.shopoo.objects.OrderDetailType;
import java.util.List;


public interface OrderDetailService {
    
    OrderDetail getOrderDetailById(long orderDetailId);

    List<OrderDetail> getAllOrderDetail();

    void addOrderDetail(OrderDetail orderDetail);

    void updateOrderDetail(OrderDetail orderDetail);

    void deleteOrderDetail(long orderDetailId);
    
    List<OrderDetail> getOrderDetailByOrdersID(long id);
}
