package in.aakashsinha.billingsimple.model;

import in.aakashsinha.billingsimple.entity.Customer;
import in.aakashsinha.billingsimple.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class BillingModel {
    private String fromAddress;
    private Customer customer;
    private List<Product> productList;
    private double subTotal;
    private double taxAmount;
    private double taxPercentage = 18;
    private double grandTotal;
    private Instant timestamp;
}
