package pl.marcin.creditservice.models;

import javax.persistence.*;

@Entity
@Table(name = "credit")
public class Credit {

    @Id
    private String id;

    @Column(nullable = false, length = 150)
    private String name;

    public Credit() {}

    public Credit(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Credit(String name, Product product, Customer customer) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
