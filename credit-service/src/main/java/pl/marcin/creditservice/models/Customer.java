package pl.marcin.creditservice.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "credit_id")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 150)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 150)
    private String lastName;

    @Column(length = 11, nullable = false)
    private int pesel;

    @OneToOne
    @MapsId
    @JoinColumn(name="credit_id")
    private Credit credit;
}
