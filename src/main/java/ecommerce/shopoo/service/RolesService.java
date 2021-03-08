package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Roles;
import ecommerce.shopoo.entity.UsersRoles;
import java.util.List;

public interface RolesService {

    Roles getRolesById(long rolesId);

    List<Roles> getAllRoles();

    void addRoles(Roles roles);

    void updateRoles(Roles roles);

    void deleteRoles(long rolesId);
}
