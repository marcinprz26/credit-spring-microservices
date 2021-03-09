package pl.marcin.productservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marcin.productservice.exceptions.ParameterValidationException;
import pl.marcin.productservice.models.Product;
import pl.marcin.productservice.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product createProduct(Product product) {
        if(product == null) {
            throw new ParameterValidationException();
        }
        return productRepository.save(product);
    }
}
