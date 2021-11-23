package com.switchfully.order.domain.customers.addresses;

import com.switchfully.order.infrastructure.builder.Builder;

import javax.persistence.*;

@Entity
@Table(name = "address")
public final class Address {

    @Id
    @SequenceGenerator(name = "address_seq", sequenceName = "ADDRESS_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    private int id;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    public Address(AddressBuilder addressBuilder) {
        this.streetName = addressBuilder.streetName;
        this.houseNumber = addressBuilder.houseNumber;
        this.postalCode = addressBuilder.postalCode;
        this.country = addressBuilder.country;
    }

    public Address() {
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Address{" + "streetName='" + streetName + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public static class AddressBuilder extends Builder<Address> {

        private String streetName;
        private String houseNumber;
        private String postalCode;
        private String country;

        private AddressBuilder() {
        }

        public static AddressBuilder address() {
            return new AddressBuilder();
        }

        @Override
        public Address build() {
            return new Address(this);
        }

        public AddressBuilder withStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public AddressBuilder withHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public AddressBuilder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public AddressBuilder withCountry(String country) {
            this.country = country;
            return this;
        }
    }

}
