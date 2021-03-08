package ecommerce.shopoo.repository;

import ecommerce.shopoo.objects.SearchProductType;
import ecommerce.shopoo.entity.Products;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Long> {

    @Query(value = "select p.id, p.productName, p.decription, p.quantityInStore, p.unitPrice, p.warranty, p.updateDate, p.types_fk, p.manufacture_fk  "
            + "from Products p "
            + "where p.updateDate >= '2021-01-01' "
            + "order by p.unitPrice asc "
            + "limit 20 ", nativeQuery = true)
    List<Products> getProductByDate();
    
    
    @Query("select p from Products p where p.productName like %?1% ")
    List<Products> getProductByName(String productName);

    @Query("select p from Products p where p.unitPrice between ?1 and ?2 ")
    List<Products> getProductsByPrice(double start, double end);

    @Query(value = "select new ecommerce.shopoo.objects.SearchProductType(p.id, p.productName, "
                                                                + "p.decription, p.quantityInStore, "
                                                                + "p.unitPrice, p.warranty, "
                                                                + "p.updateDate, "
                                                                + "p.types.typeName, "
                                                                + "p.manufacture.manufactureName, "
                                                                + "p.images.firstLink) "
            + "from Products p "
                                + "inner join p.types "
                                + "inner join p.manufacture "
                                + "inner join p.images "
            + "where p.manufacture.manufactureName like %?1%")
    List<SearchProductType> findByManufacture(String manufactureName);

    
    @Query(value = "select new ecommerce.shopoo.objects.SearchProductType(p.id, p.productName, "
            + "p.decription, p.quantityInStore, "
            + "p.unitPrice, p.warranty, "
            + "p.updateDate, "
            + "p.types.typeName, "
            + "p.manufacture.manufactureName, "
            + "p.images.firstLink) "
            + "from Products p "
            + "inner join p.types "
            + "inner join p.manufacture "
            + "inner join p.images "
            + "where p.manufacture.manufactureName like %?1% or p.productName like %?1% or p.types.typeName like %?1% or p.decription like %?1% ")
    List<SearchProductType> findByKeyword(String keywords);

    
    @Query(value = "select new ecommerce.shopoo.objects.SearchProductType(p.id, p.productName, "
            + "p.decription, p.quantityInStore, "
            + "p.unitPrice, p.warranty, "
            + "p.updateDate, "
            + "p.types.typeName, "
            + "p.manufacture.manufactureName, "
            + "p.images.firstLink) "
            + "from Products p "
            + "inner join p.types "
            + "inner join p.manufacture "
            + "inner join p.images "
            + "where p.types.typeName like %?1%")
    List<SearchProductType> findByType(String typeName);

}
