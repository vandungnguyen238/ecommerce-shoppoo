package ecommerce.shopoo.entity;

import ecommerce.shopoo.enumType.OrdersStatus;
import ecommerce.shopoo.enumType.ShippingStatus;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String shippingName;
    private String warehouse;
    private String receivedBy;
    private String description;
    private double cost;
    private OrdersStatus ordersStatus = OrdersStatus.pending;
    private ShippingStatus shippingStatus = ShippingStatus.pending;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate receivedDate; //ngay nhan hang de ship
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate shipDate;     //ngay giao cho khach hang

    @OneToMany(mappedBy = "shipping")
    private List<Orders> ordersList;

    public Shipping() {
    }

    public Shipping(long id, String shippingName, String warehouse, String receivedBy, String description, double cost, 
             OrdersStatus ordersStatus, ShippingStatus shippingStatus,
            LocalDate receivedDate, LocalDate shipDate, List<Orders> ordersList) {
        this.id = id;
        this.shippingName = shippingName;
        this.warehouse = warehouse;
        this.receivedBy = receivedBy;
        this.description = description;
        this.cost = cost;
        this.ordersStatus = ordersStatus;
        this.shippingStatus = shippingStatus;
        this.receivedDate = receivedDate;
        this.shipDate = shipDate;
        this.ordersList = ordersList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public OrdersStatus getOrdersStatus() {
        return ordersStatus;
    }

    public void setOrdersStatus(OrdersStatus ordersStatus) {
        this.ordersStatus = ordersStatus;
    }

    public ShippingStatus getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(ShippingStatus shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDate shipDate) {
        this.shipDate = shipDate;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
