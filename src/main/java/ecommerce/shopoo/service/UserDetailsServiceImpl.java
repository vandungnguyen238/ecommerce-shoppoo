package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Users;
import ecommerce.shopoo.entity.UsersRoles;
import ecommerce.shopoo.repository.UsersRepository;
import ecommerce.shopoo.repository.UsersRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersRolesRepository usersRolesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = this.usersRepository.findByUsername(username);

        if (users == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        System.out.println("Found User: " + users);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<UsersRoles> usersRolesList = this.usersRolesRepository.findByUsers(users);

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (usersRolesList != null) {
            for (UsersRoles ur : usersRolesList) {
                // GET ROLE: ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(ur.getRoles().getName());
                grantList.add(authority);
            }
        }
        UserDetails userDetails = new User(users.getUsername(), users.getPassword(), grantList);
        return userDetails;
    }

}
