package in.aakashsinha.billingsimple.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.aakashsinha.billingsimple.entity.Billing;
import in.aakashsinha.billingsimple.model.BillingModel;
import in.aakashsinha.billingsimple.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    BillingRepository billingRepository;

    @Override
    public Billing addBilling(BillingModel billingModel) {
        ObjectMapper objectMapper = new ObjectMapper();
        Billing billing = objectMapper.convertValue(billingModel, Billing.class);

        /*
        retrieve values from body
        check if customer exists, if true -> push bill id to customer bill list

        else

        create new customer then push bill id;


         */

        return billingRepository.save(billing);
    }

    @Override
    public List<Object> getAllBills() {
         return Arrays.asList(billingRepository.findAll().toArray());
    }
}
