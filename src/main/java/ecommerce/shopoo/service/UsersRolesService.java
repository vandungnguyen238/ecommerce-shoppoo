package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Users;
import ecommerce.shopoo.entity.UsersRoles;
import java.util.List;


public interface UsersRolesService {
    UsersRoles getUsersRolesById(long usersRolesId);
    
    List<UsersRoles> getUsersRolesByUsers(Users users);

    List<UsersRoles> getAllUsersRoles();

    void addUsersRoles(UsersRoles usersRoles);

    void updateUsersRoles(UsersRoles usersRoles);

    void deleteUsersRoles(long usersRolesId);
}
