package ecommerce.shopoo.objects;

import ecommerce.shopoo.enumType.OrdersStatus;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class OrderDetailType {

    private long id;
    private long orderId;
    private long productId;
    private int quantity;
    private double amount;

    public OrderDetailType() {
    }

    public OrderDetailType(long id, long orderId, long productId, int quantity, double amount) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
}
