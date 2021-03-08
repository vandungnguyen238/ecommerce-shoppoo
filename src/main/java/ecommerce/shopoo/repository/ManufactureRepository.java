package ecommerce.shopoo.repository;

import ecommerce.shopoo.entity.Manufacture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufactureRepository extends CrudRepository<Manufacture, Long>{
    
}
