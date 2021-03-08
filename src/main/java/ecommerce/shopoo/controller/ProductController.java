package ecommerce.shopoo.controller;

import ecommerce.shopoo.objects.ProductType;
import ecommerce.shopoo.entity.*;
import ecommerce.shopoo.objects.SearchProductType;
import ecommerce.shopoo.service.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private ProductsService productsService;

    @Autowired
    private TypesService typesService;

    @Autowired
    private ManufactureService manufactureService;

    @RequestMapping(value = "/list")
    public String productlist(Model model) {
        usersService.viewInfoUsersDetails(model);
        List<Products> productsList = productsService.getAllProducts();
        List<Manufacture> manufacturesList = manufactureService.getAllManufacture();
        model.addAttribute("manufacturesList", manufacturesList);
        model.addAttribute("list", productsList);
        return "product-list-page";
    }

    @RequestMapping(path = "/productmanage")
    public String manageProductList(Model model) {
        usersService.viewInfoUsersDetails(model);
        List<Products> productsList = productsService.getAllProducts();
        model.addAttribute("list", productsList);
        return "product-manage-page";
    }

    @RequestMapping(path = "/add")
    public String addProduct(Model model) {
        usersService.viewInfoUsersDetails(model);
        ProductType productType = new ProductType();
        List<Types> typesList = typesService.getAllTypes();
        List<Manufacture> manufacturesList = manufactureService.getAllManufacture();
        model.addAttribute("productType", productType);
        model.addAttribute("typesList", typesList);
        model.addAttribute("manufacturesList", manufacturesList);
        model.addAttribute("type", "add");
        return "product-update-page";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute ProductType productType, Model model) {
        usersService.viewInfoUsersDetails(model);
        Types types = typesService.getTypesById(productType.getTypesId());
        Manufacture manufactures = manufactureService.getManufactureById(productType.getManufactureId());
        Products products = new Products();
        products.setId(productType.getId());
        products.setProductName(productType.getProductName());
        products.setUnitPrice(productType.getUnitPrice());
        products.setQuantityInStore(productType.getQuantityInStore());
        products.setManufacture(manufactures);
        products.setTypes(types);
        products.setDecription(productType.getDecription());
        products.setUpdateDate(productType.getUpdateDate());
        products.setWarranty(productType.getWarranty());
        productsService.addProducts(products);
        return "redirect:/products/product-manage";
    }

    @GetMapping("/edit")
    public String updateProducts(@RequestParam("id") long id, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<Types> typesList = typesService.getAllTypes();
        List<Manufacture> manufacturesList = manufactureService.getAllManufacture();
        Products products = productsService.getProductsById(id);
        ProductType productType = new ProductType();
        productType.setId(id);
        products.setProductName(productType.getProductName());
        products.setUnitPrice(productType.getUnitPrice());
        products.setQuantityInStore(productType.getQuantityInStore());
        products.setDecription(productType.getDecription());
        products.setUpdateDate(productType.getUpdateDate());
        products.setWarranty(productType.getWarranty());

        model.addAttribute("productType", productType);
        model.addAttribute("products", products);
        model.addAttribute("typesList", typesList);
        model.addAttribute("manufacturesList", manufacturesList);
        model.addAttribute("type", "edit");
        return "product-update-page";
    }

    @GetMapping("/delete")
    public String deleteProducts(@RequestParam("id") long id, Model model) {
        usersService.viewInfoUsersDetails(model);
        productsService.deleteProducts(id);
        return "redirect:/products/product-manage";
    }

    
    @RequestMapping(path = "/product-detail")
    public String productDetail(@RequestParam("id") long id, Model model) {
        usersService.viewInfoUsersDetails(model);
        Products product = productsService.getProductsById(id);
        model.addAttribute("product", product);

        return "product-detail-page";
    }

    @RequestMapping(path = "/searchKeyWord", method = RequestMethod.GET)
    public String searchProductByKeywords(@RequestParam("keywords") String keywords, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<SearchProductType> list = productsService.searchbyKeyword(keywords);
        List<Manufacture> manufacturesList = manufactureService.getAllManufacture();
        String message;
        if (list.size() > 0) {
            message = " Found " + list.size() + " Products";
        } else {
            message = " Not Found";
        }
       
        model.addAttribute("message", message);
        model.addAttribute("list", list);
        model.addAttribute("manufacturesList", manufacturesList);
        model.addAttribute("keywords", keywords);
        return "product-search-page";
    }

    @RequestMapping(value = "/searchByProductName", method = RequestMethod.GET)
    public String searchByProductName(Model model, @RequestParam("productName") String productName) {
        usersService.viewInfoUsersDetails(model);
        List<Products> products = productsService.searchbyName(productName);
        List<Manufacture> manufacturesList = manufactureService.getAllManufacture();
        String message;
        if (products.size() > 0) {
            message = " Found " + products.size() + " Products";
        } else {
            message = " Not Found";
        }
        model.addAttribute("message", message);
        model.addAttribute("list", products);
        model.addAttribute("manufacturesList", manufacturesList);
        model.addAttribute("productName", productName);
        return "product-list-page";
    }

    @RequestMapping(path = "/searchManufactures")
    public String searchByProductCategory(Model model, @RequestParam("manufactureName") String manufactureName) {
        usersService.viewInfoUsersDetails(model);
        List<SearchProductType> products = productsService.searchbyManufacture(manufactureName);
        List<Manufacture> manufacturesList = manufactureService.getAllManufacture();
        String tag = manufactureName;
        String message;
        if (products.size() > 0) {
            message = " Found " + products.size() + " Products";
        } else {
            message = " Not Found";
        }
        model.addAttribute("tag", tag);
        model.addAttribute("message", message);
        model.addAttribute("list", products);
        model.addAttribute("manufacturesList", manufacturesList);
        return "product-search-page";
    }
    
    @RequestMapping(path = "/searchType")
    public String searchByProductType(Model model, @RequestParam("typeName") String typeName) {
        usersService.viewInfoUsersDetails(model);
        List<SearchProductType> products = productsService.searchbyType(typeName);
        List<Manufacture> manufacturesList = manufactureService.getAllManufacture();
        String tag = typeName;
        String message;
        if (products.size() > 0) {
            message = " Found " + products.size() + " Products";
        } else {
            message = " Not Found";
        }
        model.addAttribute("tag", tag);
        model.addAttribute("message", message);
        model.addAttribute("list", products);
        model.addAttribute("manufacturesList", manufacturesList);
        return "product-search-page";
    }

    @RequestMapping(value = "/searchPrice")
    public String searchByProductPrice(@RequestParam("start") double start, 
                                            @RequestParam("end") double end, Model model) {
        usersService.viewInfoUsersDetails(model);
        List<Products> products = productsService.searchbyPrice(start, end);
        List<Manufacture> manufacturesList = manufactureService.getAllManufacture();
        model.addAttribute("list", products);
        String message;
        if (products.size() > 0) {
            message = " Found " + products.size() + " Products";
        } else {
            message = " Not Found";
        }
       
        model.addAttribute("message", message);
        model.addAttribute("manufacturesList", manufacturesList);
        return "product-list-page";
    }


}
