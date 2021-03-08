package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Users;
import ecommerce.shopoo.entity.UsersRoles;
import ecommerce.shopoo.repository.UsersRolesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersRolesServiceImpl implements UsersRolesService{
    @Autowired
    private UsersRolesRepository usersRolesRepository;

    @Override
    public UsersRoles getUsersRolesById(long usersRolesId) {
        //return usersRolesRepository.findById(usersRolesId).get();
        Optional<UsersRoles> optional = usersRolesRepository.findById(usersRolesId);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public List<UsersRoles> getUsersRolesByUsers(Users users) {
        return usersRolesRepository.findByUsers(users);
    }

    @Override
    public List<UsersRoles> getAllUsersRoles() {
        return (List<UsersRoles>) usersRolesRepository.findAll();
    }

    @Override
    public void addUsersRoles(UsersRoles usersRoles) {
        usersRolesRepository.save(usersRoles);
    }

    @Override
    public void updateUsersRoles(UsersRoles usersRoles) {
        usersRolesRepository.save(usersRoles);
    }

    @Override
    public void deleteUsersRoles(long usersRolesId) {
        usersRolesRepository.deleteById(usersRolesId);
    }
}
