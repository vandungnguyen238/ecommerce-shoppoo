package ecommerce.shopoo.objects;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class DateToDate{
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate currentDate = LocalDate.now();

    public DateToDate() {
    }

    public DateToDate(LocalDate fromDate, LocalDate toDate, LocalDate currentDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.currentDate = currentDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

}
