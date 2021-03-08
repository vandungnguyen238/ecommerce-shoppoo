package ecommerce.shopoo.service;

import ecommerce.shopoo.objects.SearchProductType;
import ecommerce.shopoo.entity.Products;
import java.util.List;

public interface ProductsService {

    Products getProductsById(long productsId);
    
    List<Products> getProductByUpdateDate();

    List<Products> getAllProducts();

    void addProducts(Products products);

    void updateProducts(Products products);

    void deleteProducts(long productsId);
    
    public List<Products> searchbyName(String productName);
    
    public List<Products> searchbyPrice(double start, double end);
    
    public List<SearchProductType> searchbyManufacture(String manufactureName);
    
    public List<SearchProductType> searchbyKeyword(String keywords);
    
    public List<SearchProductType> searchbyType(String typeName);
}
