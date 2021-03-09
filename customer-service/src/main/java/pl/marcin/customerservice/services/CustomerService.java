package pl.marcin.customerservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marcin.customerservice.exceptions.ParameterValidationException;
import pl.marcin.customerservice.models.Customer;
import pl.marcin.customerservice.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer createCustomer(Customer product) {
        if(product == null) {
            throw new ParameterValidationException();
        }
        return customerRepository.save(product);
    }
}
