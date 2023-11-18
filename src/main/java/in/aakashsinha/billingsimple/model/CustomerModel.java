package in.aakashsinha.billingsimple.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerModel {
    private String name;

    private String address;
    private long phone;

    private List<Long> billingIdList;
}
