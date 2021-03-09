package pl.marcin.creditservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.marcin.creditservice.models.Credit;
import pl.marcin.creditservice.models.Customer;
import pl.marcin.creditservice.models.Product;

import java.util.List;

@RestController
public class CreditController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(name = "GetCredits")
    public List<Credit> getCredits() {
        return List.of();
    }

    @PostMapping(name = "CreateCredit")
    public Credit createCredit(@NonNull @RequestBody String creditName,
                               @NonNull @RequestBody Customer customer,
                               @NonNull @RequestBody Product product) {
        return new Credit();
    }
}
