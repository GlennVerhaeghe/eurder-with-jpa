package com.switchfully.order.domain.customers.phonenumbers;

import com.switchfully.order.infrastructure.builder.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone_number")
public final class PhoneNumber {

    @Id
    @Column(name = "number")
    private String number;

    @Column(name = "country_code")
    private String countryCallingCode;

    public PhoneNumber() {
    }

    private PhoneNumber(PhoneNumberBuilder phoneNumberBuilder) {
        this.number = phoneNumberBuilder.number;
        this.countryCallingCode = phoneNumberBuilder.countryCallingCode;
    }

    public String getNumber() {
        return number;
    }

    public String getCountryCallingCode() {
        return countryCallingCode;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" + "number='" + number + '\'' +
                ", countryCallingCode='" + countryCallingCode + '\'' +
                '}';
    }

    public static class PhoneNumberBuilder extends Builder<PhoneNumber> {
        private String number;
        private String countryCallingCode;

        private PhoneNumberBuilder() {
        }

        public static PhoneNumberBuilder phoneNumber() {
            return new PhoneNumberBuilder();
        }

        @Override
        public PhoneNumber build() {
            return new PhoneNumber(this);
        }

        public PhoneNumberBuilder withNumber(String number) {
            this.number = number;
            return this;
        }

        public PhoneNumberBuilder withCountryCallingCode(String countryCallingCode) {
            this.countryCallingCode = countryCallingCode;
            return this;
        }
    }

}
