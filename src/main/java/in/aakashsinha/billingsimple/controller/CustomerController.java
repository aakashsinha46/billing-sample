package in.aakashsinha.billingsimple.controller;

import in.aakashsinha.billingsimple.entity.Customer;
import in.aakashsinha.billingsimple.repository.CustomerRepository;
import in.aakashsinha.billingsimple.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/get/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @GetMapping("/get/phone/{phone}")
    public Long getCustomerByPhone(@PathVariable Long phone) { return  customerService.getCustomeIdByPhone(phone);}
}
