package ecommerce.shopoo.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotEmpty(message = "Not be Empty") //use @NotEmpty, not use @NotNull (khong view message)
    private String firstName;
    
    @NotEmpty(message = "Not be Empty")
    private String lastName;
    private String fullName;
    
    //@Range(min = 1, max = 10, message = "Quantity must be Ranger from 1 to 10, ahihi") //---> number
    //@Phone(message = "Phone Number is invalid")
    @NotEmpty(message = "Not be Empty")
    @Length(min = 10, max = 10)
    private String phone;
    
    @NotEmpty(message = "Not be Empty")
    private String address;
    
    @NotEmpty(message = "Not be Empty")
    @Email
    private String email;
    
    @NotBlank(message = "Not be Blank")
    @Length(min = 1, max = 50)
    private String username;
    
    @NotBlank(message = "Not be Blank")
    @Length(min = 1, max = 50)
    private String password;
    
    @NotBlank(message = "Not be Blank")
    @Length(min = 1, max = 50)
    private String confirmPassword;
    //@NotNull
    //@Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate = LocalDate.now();
    private boolean enable = false;

    @OneToMany(mappedBy = "users")
    private List<Comments> commentsList;
    @OneToMany(mappedBy = "users")
    private List<Orders> ordersList;
    @OneToMany(mappedBy = "users")
    private List<UsersRoles> usersRolesList;

    public Users() {
    }

    public Users(long id, String firstName, String lastName, String fullName, String phone, String address,
            String email, String username, String password, String confirmPassword,
            LocalDate createDate, boolean enable, List<Comments> commentsList,
            List<Orders> ordersList, List<UsersRoles> usersRolesList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.createDate = createDate;
        this.enable = enable;
        this.commentsList = commentsList;
        this.ordersList = ordersList;
        this.usersRolesList = usersRolesList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public List<UsersRoles> getUsersRolesList() {
        return usersRolesList;
    }

    public void setUsersRolesList(List<UsersRoles> usersRolesList) {
        this.usersRolesList = usersRolesList;
    }

}
