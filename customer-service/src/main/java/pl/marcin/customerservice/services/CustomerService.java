package pl.marcin.customerservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marcin.customerservice.exceptions.ParameterValidationException;
import pl.marcin.customerservice.models.Customer;
import pl.marcin.customerservice.repositories.CustomerRepository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<Customer> getAllCustomers(List<String> creditNumbers) {
        if(creditNumbers.isEmpty()) {
            throw new ParameterValidationException();
        }
        return creditNumbers.stream()
                .map(id -> customerRepository.findById(id).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public Customer createCustomer(Customer product) {
        if(product == null) {
            throw new ParameterValidationException();
        }
        return customerRepository.save(product);
    }
}
