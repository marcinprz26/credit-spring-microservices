package pl.marcin.creditservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
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

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CreditService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private final CreditRepository creditRepository;

    @Value("${service.uri.product}")
    private String productUri;
    @Value("${service.uri.customer}")
    private String customerUri;

    @Autowired
    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public List<Credit> getAllCredits() {
        List<Credit> credits = (List<Credit>) creditRepository.findAll();
        String[] creditNumbers = credits.stream().map(Credit::getId).toArray(String[]::new);


        return credits;
    }

    public String createCredit(String creditName, Product product, Customer customer) {
        if(creditName.isBlank() || product == null || customer == null) {
            throw new ParameterValidationException();
        }
        String creditId = UUID.randomUUID().toString();

        product.setId(creditId);
        createProduct(product);

        customer.setId(creditId);
        createCustomer(customer);

        Credit credit = creditRepository.save(new Credit(creditId, creditName));

        return credit.getId();
    }

    private void createProduct(Product product) {
        webClientBuilder.build().post().uri(productUri + "/CreateProduct")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(product), Product.class)
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new ParameterValidationException()))
            .bodyToMono(Product.class)
            .block();
    }

    private void createCustomer(Customer customer) {
        webClientBuilder.build().post().uri(customerUri + "/CreateCustomer")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(customer), Customer.class)
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new ParameterValidationException()))
            .bodyToMono(Customer.class)
            .block();
    }

    private List<Product> getProducts(String[] creditNumbers) {
        return webClientBuilder.build().get().uri(productUri + "/GetProducts/" + creditNumbers)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new ParameterValidationException()))
                .bodyToMono(new ParameterizedTypeReference<List<Product>>() {})
                .block();
    }

    private List<Customer> getCustomer(String[] creditNumbers) {
        return webClientBuilder.build().get().uri(customerUri + "/GetCustomers/" + creditNumbers)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new ParameterValidationException()))
                .bodyToMono(new ParameterizedTypeReference<List<Customer>>() {})
                .block();
    }
}
