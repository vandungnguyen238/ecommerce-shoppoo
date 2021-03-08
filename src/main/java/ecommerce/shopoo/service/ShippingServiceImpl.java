package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Shipping;
import ecommerce.shopoo.repository.ShippingRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingServiceImpl implements ShippingService{
    @Autowired
    private ShippingRepository shippingRepository;

    @Override
    public Shipping getShippingById(long shippingId) {
        //return shippingRepository.findById(shippingId).get();
        Optional<Shipping> optional = shippingRepository.findById(shippingId);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public List<Shipping> getAllShipping() {
        return (List<Shipping>) shippingRepository.findAll();
    }

    @Override
    public void addShipping(Shipping shipping) {
        shippingRepository.save(shipping);
    }

    @Override
    public void updateShipping(Shipping shipping) {
        shippingRepository.save(shipping);
    }

    @Override
    public void deleteShipping(long shippingId) {
        shippingRepository.deleteById(shippingId);
    }
    
//    @Override
//    public List<Shipping> getShippingByDate(LocalDate fromDate, LocalDate toDate) {
//        return shippingRepository.findByDateToDate(fromDate, toDate);
//    }
    
//    @Override
//    public List<ShippingReport> getShippingByDate(LocalDate fromDate, LocalDate toDate) {
//        return shippingRepository.findByDateToDate(fromDate, toDate);
//    }
    
    @Override
    public List<Shipping> getShippingByKeyword(String keywords) {
        return shippingRepository.findByKeyword(keywords);
    }

    @Override
    public Shipping getByShippingName(String name) {
        return shippingRepository.findByShippingName(name);
    }
}
