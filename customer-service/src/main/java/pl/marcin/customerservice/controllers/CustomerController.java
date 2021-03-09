package pl.marcin.customerservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.marcin.customerservice.models.Customer;
import pl.marcin.customerservice.services.CustomerService;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "GetCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getProducts(@RequestBody List<String> creditNumbers) {
        return customerService.getAllCustomers(creditNumbers);
    }

    @PostMapping(path = "CreateCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer create(@NonNull Customer product) {
        return customerService.createCustomer(product);
    }
}
