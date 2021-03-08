package ecommerce.shopoo.repository;

import ecommerce.shopoo.entity.Users;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
//  Cac ERROR hay gap: 
//  Query nhung field nao thi phai co them constructor cac field do
//  Thieu dau ',' cuoi cac field, rieng fiedld cuoi cung khong co dau ','
//  thieu dau ngoac (co 2 cap dau open & close)
//  cuoi dong khong co space
//  Thu tu cac feild trong query phai giong vs thu tu cac field trong ordersType
//  Orders sau 'from' phai viet hoa ki 'O'
//  Co the query so field it hon sofield cua ordersType. Query nhung field nao thi phai co them constructor cac field do
//  Thieu dau ')' close cau query
//  Kieu du lieu cua argument phai phu hop (string # long ,...)

    Users findByUsername(String username);

    @Query(value = "select u.id, u.firstName, u.lastName, u.fullName, u.phone, u.address, u.email, u.username, "
            + "u.password, u.confirmPassword, u.createDate, u.enable "
            + "from users u "
            + "order by u.createDate desc "
            + "limit 1 ", nativeQuery = true)
    List<Users> findByNewUsers();

    @Query(value = "select u.id, u.firstName, u.lastName, u.fullName, u.phone, u.address, u.email, u.username, "
            + "u.password, u.confirmPassword, u.createDate, u.enable "
            + "from users u "
            + "where u.id like %?1% or u.fullName like %?1% or u.phone like %?1% or u.address like %?1% "
            + "or u.username like %?1% ", nativeQuery = true)
    List<Users> findByString(String name);

    @Query(value = "select u.id, u.firstName, u.lastName, u.fullName, u.phone, u.address, u.email, u.username, "
            + "u.password, u.confirmPassword, u.createDate, u.enable "
            + "from users u "
            + "where u.createDate between ?1 and ?2 "
            + "order by u.createDate desc ", nativeQuery = true)
    List<Users> findByDateToDate(LocalDate fromDate, LocalDate toDate);
}

//   @Query(value = "select new ecommerce.shopoo.objects.OrdersType(o.id, "
//                                                                + "o.users.fullName, "
//                                                                + "o.users.address, "
//                                                                + "o.users.phone, "
//                                                                + "o.users.email, "
//                                                                + "o.users.username, "
//                                                                + "o.users.id, "
//                                                                + "o.shipping.id, "
//                                                                + "o.shipping.shippingName, "
//                                                                + "o.shipping.cost, "
//                                                                + "o.promotion.id, "
//                                                                + "o.promotion.discount, "
//                                                                + "o.total, "
//                                                                + "o.createDate, "
//                                                                + "o.ordersStatus "
//                                                                + ") "
//            + "from Orders o "
//                            + "inner join o.shipping "
//                            + "inner join o.promotion "
//                            + "inner join o.users "
//            + "where o.createDate between ?1 and ?2")
//    List<OrdersType> findByDateToDate(LocalDate fromDate, LocalDate toDate);
//    
//    
//    
//    
//    @Query(value = "select new ecommerce.shopoo.objects.OrdersType(o.id, "
//                                                                + "o.users.fullName, "
//                                                                + "o.users.address, "
//                                                                + "o.users.phone, "
//                                                                + "o.users.email, "
//                                                                + "o.users.username, "
//                                                                + "o.users.id, "
//                                                                + "o.shipping.id, "
//                                                                + "o.shipping.shippingName, "
//                                                                + "o.shipping.cost, "
//                                                                + "o.promotion.id, "
//                                                                + "o.promotion.discount, "
//                                                                + "o.total, "
//                                                                + "o.createDate, "
//                                                                + "o.ordersStatus "
//                                                                + ") "
//            + "from Orders o "
//                            + "inner join o.shipping "
//                            + "inner join o.promotion "
//                            + "inner join o.users "
//            + "where o.id like %?1% or "
//                                    + "o.users.fullName like %?1% or "
//                                    + "o.users.address like %?1% or "
//                                    + "o.users.phone like %?1% "
//                                    + "or o.users.email like %?1% or "
//                                    + "o.users.username like %?1% or "
//                                    + "o.shipping.shippingName like %?1% or "
//                                    + "o.promotion.name like %?1% ")
//    List<OrdersType> findByKeyword(String keywords);
