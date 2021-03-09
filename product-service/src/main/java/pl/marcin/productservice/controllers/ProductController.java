package pl.marcin.productservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import pl.marcin.productservice.models.Product;
import pl.marcin.productservice.services.ProductService;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "GetProducts/{creditNumbers}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProducts(@PathVariable String[] creditNumbers) {
        return productService.getAllProducts(List.of(creditNumbers));
    }

    @PostMapping(path = "CreateProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product create(@NonNull Product product) {
        return productService.createProduct(product);
    }
}
