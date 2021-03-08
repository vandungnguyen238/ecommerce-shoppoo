package ecommerce.shopoo.repository;

import ecommerce.shopoo.entity.Types;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesRepository extends CrudRepository<Types, Long>{
    
}
