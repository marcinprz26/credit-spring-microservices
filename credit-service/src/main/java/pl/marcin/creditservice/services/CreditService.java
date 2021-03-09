package pl.marcin.creditservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pl.marcin.creditservice.exceptions.ParameterValidationException;
import pl.marcin.creditservice.models.Credit;
import pl.marcin.creditservice.models.Customer;
import pl.marcin.creditservice.models.Product;
import pl.marcin.creditservice.reposotories.CreditRepository;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CreditService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private final CreditRepository creditRepository;

    private static final String PRODUCT_SERVICE_URI = "";
    private static final String CUSTOMER_SERVICE_URI = "";

    @Autowired
    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public List<Credit> getAllCredits() {
        return (List<Credit>) creditRepository.findAll();
    }

    public Long createCredit(String creditName, Product product, Customer customer) {
        if(creditName.isBlank() || product == null || customer == null) {
            throw new ParameterValidationException();
        }
        createProduct(product);
        createCustomer(customer);
        Credit credit = creditRepository.save(new Credit(creditName));

        return credit.getId();
    }

    private void createProduct(Product product) {
        webClientBuilder.build().post().uri(PRODUCT_SERVICE_URI + "/CreateProduct")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(product), Product.class)
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new ParameterValidationException()))
            .bodyToMono(Product.class)
            .block();
    }

    private void createCustomer(Customer customer) {
        webClientBuilder.build().post().uri(CUSTOMER_SERVICE_URI + "/CreateCustomer")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(customer), Customer.class)
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new ParameterValidationException()))
            .bodyToMono(Customer.class)
            .block();
    }
}
