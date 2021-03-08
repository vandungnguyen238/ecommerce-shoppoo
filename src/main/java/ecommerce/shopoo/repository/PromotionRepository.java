package ecommerce.shopoo.repository;

import ecommerce.shopoo.entity.Promotion;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion, Long>{
    @Query(value = "select p.id, p.name, p.startDate, p.endDate, p.discount "
            + "from Promotion p "
            + "where p.name like %?1% or p.discount like %?1% "
            +       "or p.id like %?1% ", nativeQuery = true)
    List<Promotion> findByKeyword(String keywords);
    
    
    
    Promotion findByName(String name);
}