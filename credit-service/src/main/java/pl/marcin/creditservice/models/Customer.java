package pl.marcin.creditservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Customer {

    @JsonIgnore
    private String id;
    private String firstName;
    private String lastName;
    private int pesel;

    public Customer() {}

    public Customer(String firstName, String lastName, int pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public Customer(String id, String firstName, String lastName, int pesel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }
}
