package ecommerce.shopoo.service;

import ecommerce.shopoo.entity.Orders;
import ecommerce.shopoo.entity.Promotion;
import ecommerce.shopoo.entity.Shipping;
import ecommerce.shopoo.entity.Users;
import ecommerce.shopoo.enumType.OrdersStatus;
import ecommerce.shopoo.enumType.ShippingStatus;
import ecommerce.shopoo.repository.OrdersRepository;
import ecommerce.shopoo.repository.PromotionRepository;
import ecommerce.shopoo.repository.ShippingRepository;
import ecommerce.shopoo.repository.UsersRepository;
import ecommerce.shopoo.entity.*;
import ecommerce.shopoo.repository.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private UsersRolesRepository usersRolesRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    
    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ShippingRepository shippingRepository;

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private TypesRepository typesRepository;

    @Autowired
    private ManufactureRepository manufactureRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ImagesRepository imagesRepository;

    @Override
    public Users getUsersById(long usersId) {
        //return usersRepository.findById(usersId).get();
        Optional<Users> optional = usersRepository.findById(usersId);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public Users getUsersByUserName(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public List<Users> getAllUsers() {
        return (List<Users>) usersRepository.findAll();
    }

    @Override
    public void addUsers(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void updateUsers(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void deleteUsers(long usersId) {
        usersRepository.deleteById(usersId);
    }

    @Override
    public List<Users> getNewUsers() {
        return usersRepository.findByNewUsers();
    }

    @Override
    public List<Users> getUsersByString(String name) {
        return usersRepository.findByString(name);
    }

    @Override
    public List<Users> getUsersByDate(LocalDate fromDate, LocalDate toDate) {
        return usersRepository.findByDateToDate(fromDate, toDate);
    }

    @Override
    public void insertData() {

// =========== Insert date for Users ===========================================
        LocalDate currentDate = LocalDate.now();

        Users users01 = new Users();
        users01.setId(1);
        users01.setFirstName("Văn Dũng");
        users01.setLastName("Nguyễn");
        users01.setFullName("Nguyễn Văn Dũng");
        users01.setUsername("dungdeptrai");
        users01.setPassword("123");
        users01.setConfirmPassword("123");
        users01.setEmail("aodaivietnam000@gmail.com");
        users01.setAddress("Quảng Nam");
        users01.setPhone("0123456789");
        users01.setCreateDate(currentDate);
        users01.setEnable(true);
        usersRepository.save(users01);

        Users users02 = new Users();
        users02.setId(2);
        users02.setFirstName("Phú Xuân Quang");
        users02.setLastName("Nguyễn");
        users02.setFullName("Nguyễn Phú Xuân Quang");
        users02.setUsername("quangkute");
        users02.setPassword("123");
        users02.setConfirmPassword("123");
        users02.setEmail("aodaivietnam000@gmail.com");
        users02.setAddress("Đà Nẵng");
        users02.setPhone("0123456789");
        users02.setCreateDate(currentDate);
        users02.setEnable(true);
        usersRepository.save(users02);

        Users users03 = new Users();
        users03.setId(3);
        users03.setFirstName("Thiện Minh");
        users03.setLastName("Mai");
        users03.setFullName("Mai Thiện Minh");
        users03.setUsername("minhnghiemtuc");
        users03.setPassword("123");
        users03.setConfirmPassword("123");
        users03.setEmail("aodaivietnam000@gmail.com");
        users03.setAddress("Đà Nẵng");
        users03.setPhone("0123456789");
        users03.setCreateDate(currentDate);
        users03.setEnable(true);
        usersRepository.save(users03);

        Users users04 = new Users();
        users04.setId(4);
        users04.setFirstName("Customer");
        users04.setLastName("01");
        users04.setFullName("Customer 01");
        users04.setUsername("User01");
        users04.setPassword("123");
        users04.setConfirmPassword("123");
        users04.setEmail("aodaivietnam000@gmail.com");
        users04.setAddress("Đà Nẵng");
        users04.setPhone("0123456789");
        users04.setCreateDate(currentDate);
        users04.setEnable(true);
        usersRepository.save(users04);

        Users users05 = new Users();
        users05.setId(5);
        users05.setFirstName("Customer");
        users05.setLastName("02");
        users05.setFullName("Customer 01");
        users05.setUsername("User02");
        users05.setPassword("123");
        users05.setConfirmPassword("123");
        users05.setEmail("aodaivietnam000@gmail.com");
        users05.setAddress("Đà Nẵng");
        users05.setPhone("0123456789");
        users05.setCreateDate(currentDate);
        users05.setEnable(true);
        usersRepository.save(users05);
// =========== Insert date for Role ============================================
        Roles roles01 = new Roles();
        roles01.setId(1);
        roles01.setName("ROLE_ADMIN");
        rolesRepository.save(roles01);

        Roles roles02 = new Roles();
        roles02.setId(2);
        roles02.setName("ROLE_USER");
        rolesRepository.save(roles02);

        Roles roles03 = new Roles();
        roles03.setId(3);
        roles03.setName("ROLE_GUEST");
        rolesRepository.save(roles03);

// =========== Insert date for UsersRole =======================================
        UsersRoles usersRoles01 = new UsersRoles();
        usersRoles01.setId(1);
        usersRoles01.setUsers(users01);
        usersRoles01.setRoles(roles01);
        usersRolesRepository.save(usersRoles01);

        UsersRoles usersRoles02 = new UsersRoles();
        usersRoles02.setId(2);
        usersRoles02.setUsers(users02);
        usersRoles02.setRoles(roles02);
        usersRolesRepository.save(usersRoles02);

        UsersRoles usersRoles03 = new UsersRoles();
        usersRoles03.setId(3);
        usersRoles03.setUsers(users03);
        usersRoles03.setRoles(roles02);
        usersRolesRepository.save(usersRoles03);

        UsersRoles usersRoles04 = new UsersRoles();
        usersRoles04.setId(4);
        usersRoles04.setUsers(users04);
        usersRoles04.setRoles(roles03);
        usersRolesRepository.save(usersRoles04);

        UsersRoles usersRoles05 = new UsersRoles();
        usersRoles05.setId(5);
        usersRoles05.setUsers(users05);
        usersRoles05.setRoles(roles03);
        usersRolesRepository.save(usersRoles05);

        UsersRoles usersRoles06 = new UsersRoles();
        usersRoles06.setId(6);
        usersRoles06.setUsers(users01);
        usersRoles06.setRoles(roles02);
        usersRolesRepository.save(usersRoles06);

// =========== Insert data for Promotion =======================================
        Promotion promotion1 = new Promotion();
        promotion1.setId(1);
        promotion1.setName("Event New Year");
        promotion1.setStartDate(LocalDate.parse("2021-01-01"));
        promotion1.setEndDate(LocalDate.parse("2021-03-31"));
        promotion1.setDiscount(0.2);
        promotionRepository.save(promotion1);

        Promotion promotion2 = new Promotion();
        promotion2.setId(2);
        promotion2.setName("Event Summer");
        promotion2.setStartDate(LocalDate.parse("2021-07-01"));
        promotion2.setEndDate(LocalDate.parse("2021-09-30"));
        promotion2.setDiscount(0.1);
        promotionRepository.save(promotion2);

// =========== Insert data for Shipping ========================================
        Shipping shipping1 = new Shipping();
        shipping1.setId(1);
        shipping1.setShippingName("Shipping01 Company");
        shipping1.setWarehouse("Ha Noi");
        shipping1.setDescription("van chuyen bang duong sat");
        shipping1.setReceivedBy("Shipper 01");
        shipping1.setOrdersStatus(OrdersStatus.shipped);
        shipping1.setShippingStatus(ShippingStatus.shipped);
        shipping1.setReceivedDate(currentDate);
        shipping1.setShipDate(currentDate);
        shipping1.setCost(150);
        shippingRepository.save(shipping1);

        Shipping shipping2 = new Shipping();
        shipping2.setId(2);
        shipping2.setShippingName("Shipping02 Company");
        shipping2.setWarehouse("Sai Gon");
        shipping2.setDescription("van chuyen bang duong bo");
        shipping2.setReceivedBy("Shipper 02");
        shipping2.setOrdersStatus(OrdersStatus.shipped);
        shipping2.setShippingStatus(ShippingStatus.shipped);
        shipping2.setReceivedDate(currentDate);
        shipping2.setShipDate(currentDate);
        shipping2.setCost(250);
        shippingRepository.save(shipping2);

// =========== Insert data for Orders ========================================
        Orders orders1 = new Orders();
        orders1.setId(1);
        orders1.setCreateDate(currentDate);
        orders1.setTotal(500);
        orders1.setOrdersStatus(OrdersStatus.received);
        orders1.setShipping(shipping1);
        orders1.setPromotion(promotion1);
        orders1.setUsers(users01);
        ordersRepository.save(orders1);
        Orders orders2 = new Orders();
        orders2.setId(2);
        orders2.setCreateDate(currentDate);
        orders2.setTotal(1000);
        orders2.setOrdersStatus(OrdersStatus.received);
        orders2.setShipping(shipping2);
        orders2.setPromotion(promotion2);
        orders2.setUsers(users01);
        ordersRepository.save(orders2);

        Orders orders3 = new Orders();
        orders3.setId(3);
        orders3.setCreateDate(currentDate);
        orders3.setTotal(3000);
        orders3.setOrdersStatus(OrdersStatus.received);
        orders3.setShipping(shipping1);
        orders3.setPromotion(promotion1);
        orders3.setUsers(users01);
        ordersRepository.save(orders3);
    }

    @Override
    public void viewInfoUsersDetails(Model model) {
        //addAdttribute viewUsers
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            Users viewUsers = getUsersByUserName(userDetail.getUsername());
            //If role == admin --> view manageAccount
            List<UsersRoles> usersRolesList = usersRolesRepository.findByUsers(viewUsers);
            String roleName = "ROLE_USER";
            List<GrantedAuthority> grantList = new ArrayList<>();
            if (usersRolesList != null) {
                for (UsersRoles ur : usersRolesList) {
                    if (ur.getRoles().getName().equals("ROLE_ADMIN")) {
                        roleName = ur.getRoles().getName();
                        break;
                    }
                }
            }
            model.addAttribute("roleName", roleName);
            model.addAttribute("viewUsers", viewUsers);
        }
    }

    @Override
    public Users getUsersByAuthentication() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            Users users = getUsersByUserName(userDetail.getUsername());
            return users;
        }
        return null;
    }

    @Override
    public boolean existingUsername(String username) {
        for (Users u : this.getAllUsers()) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
