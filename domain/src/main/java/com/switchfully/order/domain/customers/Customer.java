package com.switchfully.order.domain.customers;

import com.switchfully.order.domain.Entity;
import com.switchfully.order.domain.customers.addresses.Address;
import com.switchfully.order.domain.customers.emails.Email;
import com.switchfully.order.domain.customers.phonenumbers.PhoneNumber;
import com.switchfully.order.infrastructure.builder.Builder;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;
import java.util.UUID;

@javax.persistence.Entity
@Table(name = "customers")
public class Customer extends Entity {

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @OneToOne
    @JoinColumn(name = "email_id", referencedColumnName = "id")
    private Email email;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "phone_nr", referencedColumnName = "number")
    private PhoneNumber phoneNumber;

    public Customer() {
    }

    private Customer(CustomerBuilder customerBuilder) {
        super(customerBuilder.id);
        this.firstname = customerBuilder.firstname;
        this.lastname = customerBuilder.lastname;
        this.email = customerBuilder.email;
        this.address = customerBuilder.address;
        this.phoneNumber = customerBuilder.phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + getId() + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email=" + email +
                ", address=" + address +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public static class CustomerBuilder extends Builder<Customer> {

        private UUID id;
        private String firstname;
        private String lastname;
        private Email email;
        private Address address;
        private PhoneNumber phoneNumber;

        private CustomerBuilder() {
        }

        public static CustomerBuilder customer() {
            return new CustomerBuilder();
        }

        @Override
        public Customer build() {
            return new Customer(this);
        }

        public CustomerBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public CustomerBuilder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public CustomerBuilder withEmail(Email email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder withPhoneNumber(PhoneNumber phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

    }
}
