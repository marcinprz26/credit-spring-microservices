package pl.marcin.customerservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import pl.marcin.customerservice.models.Customer;
import pl.marcin.customerservice.services.CustomerService;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "GetCustomers/{creditNumbers}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getProducts(@PathVariable String[] creditNumbers) {
        return customerService.getAllCustomers(List.of(creditNumbers));
    }

    @PostMapping(path = "CreateCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer create(@NonNull Customer product) {
        return customerService.createCustomer(product);
    }
}
