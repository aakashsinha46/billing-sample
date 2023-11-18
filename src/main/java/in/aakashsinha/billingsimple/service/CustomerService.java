package in.aakashsinha.billingsimple.service;

import in.aakashsinha.billingsimple.model.CustomerModel;

public interface CustomerService {

     public boolean createCustomer(CustomerModel customerModel);

     public boolean checkCustomerExist(Long phoneNumber);
}
