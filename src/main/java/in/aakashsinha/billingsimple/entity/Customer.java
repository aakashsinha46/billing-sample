package in.aakashsinha.billingsimple.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "customer")
public class Customer {

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE", unique = true)
    private long phone;

    @Column(name = "BILLING_HISTORY")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Long> billingIdList;
}
