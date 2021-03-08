package ecommerce.shopoo.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "products")
public class Products{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productName;
    private String decription;
    private int quantityInStore;
    private double unitPrice;
    private String warranty;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateDate;
    
    @OneToOne(mappedBy = "products")
    private Images images;
    
    @OneToMany(mappedBy = "products")
    private List<ProductDetail> productDetailList;
    
    @OneToMany(mappedBy = "products")
    private List<Comments> commentsList;
    
    @OneToMany(mappedBy = "products")
    private List<OrderDetail> orderDetailList;
    
    @ManyToOne
    @JoinColumn(name = "types_fk")
    private Types types;
    
    @ManyToOne
    @JoinColumn(name = "manufacture_fk")
    private Manufacture manufacture;
   

    public Products() {
    }

    public Products(long id, String productName, String decription, int quantityInStore, double unitPrice, String warranty, LocalDate updateDate, 
                            Images images, List<ProductDetail> productDetailList, List<Comments> commentsList, Types types, Manufacture manufacture,
                            List<OrderDetail> orderDetailList) {
        this.id = id;
        this.productName = productName;
        this.decription = decription;
        this.quantityInStore = quantityInStore;
        this.unitPrice = unitPrice;
        this.warranty = warranty;
        this.updateDate = updateDate;
        this.images = images;
        this.productDetailList = productDetailList;
        this.commentsList = commentsList;
        this.types = types;
        this.manufacture = manufacture;
        this.orderDetailList = orderDetailList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getQuantityInStore() {
        return quantityInStore;
    }

    public void setQuantityInStore(int quantityInStore) {
        this.quantityInStore = quantityInStore;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public List<ProductDetail> getColorList() {
        return productDetailList;
    }

    public void setColorList(List<ProductDetail> productDetailList) {
        this.productDetailList = productDetailList;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public List<OrderDetail> getOrderDetailsList() {
        return orderDetailList;
    }

    public void setOrderDetailsList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
