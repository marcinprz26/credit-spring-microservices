package pl.marcin.creditservice.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "credit_id")
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 10)
    private BigDecimal value;

    @OneToOne
    @MapsId
    @JoinColumn(name = "credit_id")
    private Credit credit;

    public Product() {}

    public Product(Long id, String name, BigDecimal value, Credit credit) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.credit = credit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }
}
