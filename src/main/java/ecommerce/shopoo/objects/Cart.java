package ecommerce.shopoo.objects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

public class Cart{
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;
    private List<LineItem> lineItemsList = new ArrayList<>();

    public Cart() {
    }

    public Cart(LocalDate createDate, List<LineItem> lineItemsList) {
        this.createDate = createDate;
        this.lineItemsList = lineItemsList;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
    
    public List<LineItem> getLineItemsList() {
        return lineItemsList;
    }

    public void setLineItemsList(List<LineItem> lineItemsList) {
        this.lineItemsList = lineItemsList;
    }

}
