package in.aakashsinha.billingsimple.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.aakashsinha.billingsimple.entity.Billing;
import in.aakashsinha.billingsimple.entity.Customer;
import in.aakashsinha.billingsimple.model.CustomerModel;
import in.aakashsinha.billingsimple.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Long createCustomer(CustomerModel customerModel) {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = objectMapper.convertValue(customerModel, Customer.class);
        return customerRepository.save(customer).getId();
    }

    @Override
    public Boolean checkCustomerExist( Long phoneNumber) {
        return customerRepository.findByPhone(phoneNumber);
    }

    @Override
    public void addBillingToCustomer(Long customerId, Long billingId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();

        List<Long> billingIdList = customer.getBillingIdList();
        billingIdList.add(billingId);

        customer.setBillingIdList(billingIdList);

        customerRepository.save(customer);

    }

    @Override
    public long getCustomeIdByPhone(long phone) {
        return customerRepository.getCustomerIdByPhone(phone);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow();
    }
}
