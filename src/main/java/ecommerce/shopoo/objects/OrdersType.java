package ecommerce.shopoo.objects;

import ecommerce.shopoo.enumType.OrdersStatus;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class OrdersType {

    private long id;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String username;
    private long usersId;

    private long shippingId;
    private String shippingName;
    private double cost;
    
    private long promotionId;
    private double discount;
    
    private double total;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;
    private OrdersStatus ordersStatus;

    public OrdersType() {
    }

    public OrdersType(long id, String fullName, String address, String phone, String email, String username, String shippingName, double cost, double discount, double total, LocalDate createDate, OrdersStatus ordersStatus) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.shippingName = shippingName;
        this.cost = cost;
        this.discount = discount;
        this.total = total;
        this.createDate = createDate;
        this.ordersStatus = ordersStatus;
    }

    public OrdersType(long id, String fullName, String address, String phone, String email, String username, long usersId, long shippingId, String shippingName, double cost, long promotionId, double discount, double total, LocalDate createDate, OrdersStatus ordersStatus) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.usersId = usersId;
        this.shippingId = shippingId;
        this.shippingName = shippingName;
        this.cost = cost;
        this.promotionId = promotionId;
        this.discount = discount;
        this.total = total;
        this.createDate = createDate;
        this.ordersStatus = ordersStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    public long getShippingId() {
        return shippingId;
    }

    public void setShippingId(long shippingId) {
        this.shippingId = shippingId;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(long promotionId) {
        this.promotionId = promotionId;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public OrdersStatus getOrdersStatus() {
        return ordersStatus;
    }

    public void setOrdersStatus(OrdersStatus ordersStatus) {
        this.ordersStatus = ordersStatus;
    }
    
}
