package ecommerce.shopoo.repository;

import ecommerce.shopoo.entity.Shipping;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends CrudRepository<Shipping, Long>{
   
    @Query(value = "select s.id, s.shippingName, s.warehouse, s.receivedBy, s.description, "
            +      "s.cost, s.ordersStatus, s.shippingStatus, s.receivedDate, s.shipDate  "
            + "from Shipping s "
            + "where s.shippingName like %?1% or s.warehouse like %?1% "
            +       "or s.ordersStatus like %?1% or s.shippingStatus like %?1% ", nativeQuery = true)
    
    List<Shipping> findByKeyword(String keywords);
    
    
    
    Shipping findByShippingName(String name);
}