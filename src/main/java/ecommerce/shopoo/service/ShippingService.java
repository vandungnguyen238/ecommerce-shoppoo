package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Shipping;
import java.time.LocalDate;
import java.util.List;


public interface ShippingService {
    Shipping getShippingById(long shippingId);

    List<Shipping> getAllShipping();

    void addShipping(Shipping shipping);

    void updateShipping(Shipping shipping);

    void deleteShipping(long shippingId);
    
//    List<Shipping> getShippingByDate(LocalDate fromDate, LocalDate toDate);
    
//    List<ShippingReport> getShippingByDate(LocalDate fromDate, LocalDate toDate);
    
    List<Shipping> getShippingByKeyword(String keywords);
    
    Shipping getByShippingName(String name);
    
}
