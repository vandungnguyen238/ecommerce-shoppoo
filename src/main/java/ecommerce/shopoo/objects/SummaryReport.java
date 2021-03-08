package ecommerce.shopoo.objects;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class SummaryReport {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reportDate;
    private double numberOfOrders;

    public SummaryReport() {
    }

    public SummaryReport(LocalDate reportDate, double numberOfOrders) {
        this.reportDate = reportDate;
        this.numberOfOrders = numberOfOrders;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public double getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(double numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }
    
}
