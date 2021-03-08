package ecommerce.shopoo.entity;

import ecommerce.shopoo.enumType.OrdersStatus;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orders")
public class Orders{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate = LocalDate.now();;
    private double total;
    private OrdersStatus ordersStatus = OrdersStatus.pending;
    
    @ManyToOne
    @JoinColumn(name = "shipping_fk")
    private Shipping shipping;
    
    @OneToMany(mappedBy = "orders")
    private List<OrderDetail> orderDetailsList;
    
    @ManyToOne
    @JoinColumn(name = "promotion_fk")
    private Promotion promotion;

    @ManyToOne
    @JoinColumn(name = "users_fk")
    private Users users;
    
    public Orders() {
    }

    public Orders(long id, double total, Shipping shipping, List<OrderDetail> orderDetailsList, Promotion promotion, Users users) {
        this.id = id;
        this.total = total;
        this.shipping = shipping;
        this.orderDetailsList = orderDetailsList;
        this.promotion = promotion;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public OrdersStatus getOrdersStatus() {
        return ordersStatus;
    }

    public void setOrdersStatus(OrdersStatus ordersStatus) {
        this.ordersStatus = ordersStatus;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public List<OrderDetail> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetail> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

}
