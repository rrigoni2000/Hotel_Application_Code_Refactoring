package it.unibz.src.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Customer {
    private String name;
    private String contact;
    private Gender gender;

    public Customer(@JsonProperty("name") String name, @JsonProperty("contact") String contact, @JsonProperty("gender") Gender gender) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getName().equals(customer.getName()) && getGender() == customer.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGender());
    }

    public String getCustomerDetails() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ").append(this.name).append("\n");
        builder.append("Gender: ").append(this.gender).append("\n");
        builder.append("Contact: ").append(this.contact).append("\n");
        return builder.toString();
    }
}
