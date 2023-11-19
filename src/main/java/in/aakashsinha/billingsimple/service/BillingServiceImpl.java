package in.aakashsinha.billingsimple.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.aakashsinha.billingsimple.entity.Billing;
import in.aakashsinha.billingsimple.entity.Customer;
import in.aakashsinha.billingsimple.model.BillingModel;
import in.aakashsinha.billingsimple.model.CustomerModel;
import in.aakashsinha.billingsimple.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    BillingRepository billingRepository;

    @Autowired
    CustomerService customerService;

    @Override
    public Billing addBilling(BillingModel billingModel) {
        /*
        retrieve values from body
        check if customer exists, if true,
        get customer id, -> push bill id to customer bill list
        else
        create new customer then push bill id;
         */

        ObjectMapper objectMapper = new ObjectMapper();
        long customerId;

        //checking if (!customer exist)? create and get id : get id
        if(!customerService.checkCustomerExist(billingModel.getCustomer().getPhone())){
            CustomerModel customerModel = objectMapper.convertValue(billingModel.getCustomer(), CustomerModel.class);
            customerId = customerService.createCustomer(customerModel);
        }else{
            customerId = customerService.getCustomeIdByPhone(billingModel.getCustomer().getPhone());
        }

        // adding customerId to billingModel's customer
        billingModel.getCustomer().setId(customerId);
        Billing billing = objectMapper.convertValue(billingModel, Billing.class);

        billing = billingRepository.save(billing);

        //adding billings to customer's billingList
        customerService.addBillingToCustomer(customerId, billing.getId());

        return billing;
    }

    @Override
    public List<Object> getAllBills() {
         return Arrays.asList(billingRepository.findAll().toArray());
    }
}
