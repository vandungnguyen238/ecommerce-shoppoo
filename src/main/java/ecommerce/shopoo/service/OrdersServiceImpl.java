package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Orders;
import ecommerce.shopoo.enumType.OrdersStatus;
import ecommerce.shopoo.objects.OrdersType;
import ecommerce.shopoo.repository.OrdersRepository;
import ecommerce.shopoo.repository.PromotionRepository;
import ecommerce.shopoo.repository.ShippingRepository;
import ecommerce.shopoo.repository.UsersRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ShippingRepository shippingRepository;

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Orders getOrdersById(long ordersId) {
        //return ordersRepository.findById(ordersId).get();
        Optional<Orders> optional = ordersRepository.findById(ordersId);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public List<Orders> getAllOrders() {
        return (List<Orders>) ordersRepository.findAll();
    }

    @Override
    public void addOrders(Orders orders) {
        ordersRepository.save(orders);
    }

    @Override
    public void updateOrders(Orders orders) {
        ordersRepository.save(orders);
    }

    @Override
    public void deleteOrders(long ordersId) {
        ordersRepository.deleteById(ordersId);
    }

    @Override
    public List<OrdersType> getOrdersByDate(LocalDate fromDate, LocalDate toDate) {
        return ordersRepository.findByDateToDate(fromDate, toDate);
    }

    @Override
    public List<OrdersType> getOrdersByString(String keywords) {
        return ordersRepository.findByString(keywords);
    }

    @Override
    public List<OrdersType> getOrdersByID(long id) {
        return ordersRepository.findOrdersByID(id);
    }

    @Override
    public List<OrdersType> getStatusOrder(OrdersStatus ordersStatus) {
        return ordersRepository.findStatusOrder(ordersStatus);
    }

    @Override
    public List<OrdersType> getMyOrders(String username) {
        return ordersRepository.findMyOrder(username);
    }
}
