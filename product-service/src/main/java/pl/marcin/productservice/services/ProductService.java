package pl.marcin.productservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pl.marcin.productservice.exceptions.ParameterValidationException;
import pl.marcin.productservice.models.Product;
import pl.marcin.productservice.repositories.ProductRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(List<String> creditNumbers) {
        if(creditNumbers.isEmpty()) {
            throw new ParameterValidationException();
        }
        return creditNumbers.stream()
                .map(id -> productRepository.findById(id).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public Product createProduct(Product product) {
        if(product == null) {
            throw new ParameterValidationException();
        }
        return productRepository.save(product);
    }
}
