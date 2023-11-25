package in.aakashsinha.billingsimple.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(
        name = "billing"
)
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "BILLING_ID")
    private long id;

    @Column(name = "FROM_ADDRESS")
    private String fromAddress;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PRODUCT_LIST")
    private List<Product> productList;

    @Column(name = "SUB_TOTAL")
    private double subTotal;

    @Column(name = "TAX_AMOUNT")
    private double taxAmount;

    @Column(name = "TAX_PERCENTAGE")
    private double taxPercentage = 18;

    @Column(name = "GRAND_TOTAL")
    private double grandTotal;

    @Column(name = "TIMESTAMP")
    private Instant timestamp;



}
