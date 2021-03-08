package ecommerce.shopoo.repository;

import ecommerce.shopoo.entity.Users;
import ecommerce.shopoo.entity.UsersRoles;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UsersRolesRepository extends CrudRepository<UsersRoles, Long> {

    List<UsersRoles> findByUsers(Users users);
}
