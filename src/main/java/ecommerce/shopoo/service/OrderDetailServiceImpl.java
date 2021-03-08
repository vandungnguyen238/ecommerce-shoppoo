package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.OrderDetail;
import ecommerce.shopoo.objects.OrderDetailType;
import ecommerce.shopoo.repository.OrderDetailRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetail getOrderDetailById(long orderDetailId) {
        //return orderDetailRepository.findById(orderDetailId).get();
        Optional<OrderDetail> optional = orderDetailRepository.findById(orderDetailId);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public List<OrderDetail> getAllOrderDetail() {
        return (List<OrderDetail>) orderDetailRepository.findAll();
    }

    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public void deleteOrderDetail(long orderDetailId) {
        orderDetailRepository.deleteById(orderDetailId);
    }

    @Override
    public List<OrderDetail> getOrderDetailByOrdersID(long id) {
        return orderDetailRepository.getByOrdersID(id);
    }
}
