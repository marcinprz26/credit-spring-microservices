package pl.marcin.creditservice.models;

public class CreditSummary {

    private String name;
    private Product product;
    private Customer customer;

    public CreditSummary(String name, Product product, Customer customer) {
        this.name = name;
        this.product = product;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
