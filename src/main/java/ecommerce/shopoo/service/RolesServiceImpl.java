package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Roles;
import ecommerce.shopoo.entity.UsersRoles;
import ecommerce.shopoo.repository.RolesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl implements RolesService{
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public Roles getRolesById(long rolesId) {
        //return rolesRepository.findById(rolesId).get();
        Optional<Roles> optional = rolesRepository.findById(rolesId);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public List<Roles> getAllRoles() {
        return (List<Roles>) rolesRepository.findAll();
    }

    @Override
    public void addRoles(Roles roles) {
        rolesRepository.save(roles);
    }

    @Override
    public void updateRoles(Roles roles) {
        rolesRepository.save(roles);
    }

    @Override
    public void deleteRoles(long rolesId) {
        rolesRepository.deleteById(rolesId);
    }
}
