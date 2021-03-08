package ecommerce.shopoo.objects;

import ecommerce.shopoo.entity.Products;


public class LineItem {
    private Products products;
    private int quantity;

    public LineItem() {
    }

    public LineItem(Products products, int quantity) {
        this.products = products;
        this.quantity = quantity;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
