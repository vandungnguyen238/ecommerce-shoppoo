package ecommerce.shopoo.repository;

import ecommerce.shopoo.entity.OrderDetail;
import ecommerce.shopoo.objects.OrderDetailType;
import ecommerce.shopoo.objects.OrdersType;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long>{
      
    @Query(value = "select o.id "
                        + ", o.orders_fk "
                        + ", o.product_fk "
                        + ", o.quantity "
                        + ", o.amount "
            + "from OrderDetail o "
            + "where o.orders_fk = ?1 ", nativeQuery = true)
    List<OrderDetail> getByOrdersID(long id);
}
