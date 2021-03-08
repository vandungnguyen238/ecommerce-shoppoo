package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Users;
import java.time.LocalDate;
import java.util.List;
import org.springframework.ui.Model;

public interface UsersService {

    Users getUsersById(long usersId);
    
    Users getUsersByUserName(String username);
    
    Users getUsersByAuthentication();

    List<Users> getAllUsers();

    void addUsers(Users users);

    void updateUsers(Users users);

    void deleteUsers(long usersId);
    
    List<Users> getNewUsers();
    
    List<Users> getUsersByString(String name);
    
    List<Users> getUsersByDate(LocalDate fromDate, LocalDate toDate);
    
    void insertData();
    
    void viewInfoUsersDetails(Model model);
    
    boolean existingUsername(String username);
}
