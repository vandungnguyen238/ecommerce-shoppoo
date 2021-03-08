/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package ecommerce.shopoo.objects;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class ProductType {

    private long id;
    private String productName;
    private String decription;
    private int quantityInStore;
    private double unitPrice;
    private String warranty;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateDate;
    private long typesId;
    private String typeName;
    private long manufactureId;
    private String manufactureName;

    public ProductType() {
    }

    public ProductType(long id, String productName, String decription, int quantityInStore, double unitPrice, String warranty, LocalDate updateDate, long typesId, String typeName, long manufactureId, String manufactureName) {
        this.id = id;
        this.productName = productName;
        this.decription = decription;
        this.quantityInStore = quantityInStore;
        this.unitPrice = unitPrice;
        this.warranty = warranty;
        this.updateDate = updateDate;
        this.typesId = typesId;
        this.typeName = typeName;
        this.manufactureId = manufactureId;
        this.manufactureName = manufactureName;
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

    public long getTypesId() {
        return typesId;
    }

    public void setTypesId(long typesId) {
        this.typesId = typesId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public long getManufactureId() {
        return manufactureId;
    }

    public void setManufactureId(long manufactureId) {
        this.manufactureId = manufactureId;
    }

    public String getManufactureName() {
        return manufactureName;
    }

    public void setManufactureName(String manufactureName) {
        this.manufactureName = manufactureName;
    }

}
