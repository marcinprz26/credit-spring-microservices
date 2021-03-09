package pl.marcin.customerservice.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.marcin.customerservice.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {
}
