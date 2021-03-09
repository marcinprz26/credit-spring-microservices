package pl.marcin.creditservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.marcin.creditservice.models.Credit;
import pl.marcin.creditservice.models.Customer;
import pl.marcin.creditservice.models.Product;
import pl.marcin.creditservice.services.CreditService;

import java.util.List;

@RestController
public class CreditController {

    @Autowired
    private CreditService creditService;

    @GetMapping(path = "GetCredits", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Credit> getCredits() {
        return creditService.getAllCredits();
    }

    @PostMapping(path = "CreateCredit", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createCredit(@NonNull @RequestBody String creditName,
                               @NonNull @RequestBody Customer customer,
                               @NonNull @RequestBody Product product) {
        return creditService.createCredit(creditName, product, customer);
    }
}
