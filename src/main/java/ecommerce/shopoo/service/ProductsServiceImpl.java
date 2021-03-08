package ecommerce.shopoo.service;

import ecommerce.shopoo.objects.SearchProductType;
import ecommerce.shopoo.entity.Products;
import ecommerce.shopoo.repository.ProductsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Products getProductsById(long productsId) {
        //return productsRepository.findById(productsId).get();
        Optional<Products> optional = productsRepository.findById(productsId);
        return optional.isPresent() ? optional.get() : null;
    }
    
    @Override
    public List<Products> getProductByUpdateDate(){
        return productsRepository.getProductByDate();
    }

    @Override
    public List<Products> getAllProducts() {
        return (List<Products>) productsRepository.findAll();
    }

    @Override
    public void addProducts(Products products) {
        productsRepository.save(products);
    }

    @Override
    public void updateProducts(Products products) {
        productsRepository.save(products);
    }

    @Override
    public void deleteProducts(long productsId) {
        productsRepository.deleteById(productsId);
    }

   

    @Override
    public List<Products> searchbyName(String productName) {
       return productsRepository.getProductByName(productName);
    }

    @Override
    public List<Products> searchbyPrice(double start, double end) {
       return productsRepository.getProductsByPrice(start, end);
    }

    @Override
    public List<SearchProductType> searchbyManufacture(String manufactureName) {
        return productsRepository.findByManufacture(manufactureName);
    }

    @Override
    public List<SearchProductType> searchbyKeyword(String keywords) {
        return productsRepository.findByKeyword(keywords);
                }

    @Override
    public List<SearchProductType> searchbyType(String typeName) {
        return productsRepository.findByType(typeName);
    }

}
