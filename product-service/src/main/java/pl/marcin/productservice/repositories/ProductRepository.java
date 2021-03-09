package pl.marcin.productservice.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.marcin.productservice.models.Product;

public interface ProductRepository extends CrudRepository<Product, String> {
}
