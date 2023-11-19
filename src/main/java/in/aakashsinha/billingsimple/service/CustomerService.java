package in.aakashsinha.billingsimple.service;

import in.aakashsinha.billingsimple.entity.Customer;
import in.aakashsinha.billingsimple.model.CustomerModel;

public interface CustomerService {

     public Long createCustomer(CustomerModel customerModel);

     public Boolean checkCustomerExist(Long phoneNumber);

     public void addBillingToCustomer(Long customerId, Long billingId);

     long getCustomeIdByPhone(long phone);

     Customer getCustomerById(Long id);
}
