package ecommerce.shopoo.objects;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class CreditReport {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reportDate;
    private String reporter;
    private double paid;
    private double unpaid;
    private double totalPaid;

    public CreditReport() {
    }

    public CreditReport(LocalDate reportDate, String reporter, double paid, double unpaid, double totalPaid) {
        this.reportDate = reportDate;
        this.reporter = reporter;
        this.paid = paid;
        this.unpaid = unpaid;
        this.totalPaid = totalPaid;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(double unpaid) {
        this.unpaid = unpaid;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }
    
}
