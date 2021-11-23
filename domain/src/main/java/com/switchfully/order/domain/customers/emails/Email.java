package com.switchfully.order.domain.customers.emails;

import com.switchfully.order.infrastructure.builder.Builder;

import javax.persistence.*;

@Entity
@Table(name = "email")
public final class Email {

    @Id
    @SequenceGenerator(name = "email_seq", sequenceName = "EMAIL_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_seq")
    private int id;

    @Column(name = "local_part")
    private String localPart;

    @Column(name = "domain")
    private String domain;

    @Transient
    private String complete;

    private Email(EmailBuilder emailBuilder) {
        this.localPart = emailBuilder.localPart;
        this.domain = emailBuilder.domain;
        this.complete = emailBuilder.complete;
    }

    public Email() {
    }

    public String getLocalPart() {
        return localPart;
    }

    public String getDomain() {
        return domain;
    }

    public String getComplete() {
        return complete;
    }

    @Override
    public String toString() {
        return "Email{" + "localPart='" + localPart + '\'' +
                ", domain='" + domain + '\'' +
                ", complete='" + complete + '\'' +
                '}';
    }

    public static class EmailBuilder extends Builder<Email> {

        private String localPart;
        private String domain;
        private String complete;

        private EmailBuilder() {
        }

        public static EmailBuilder email() {
            return new EmailBuilder();
        }

        @Override
        public Email build() {
            return new Email(this);
        }

        public EmailBuilder withLocalPart(String localPart) {
            this.localPart = localPart;
            return this;
        }

        public EmailBuilder withDomain(String domain) {
            this.domain = domain;
            return this;
        }

        public EmailBuilder withComplete(String complete) {
            this.complete = complete;
            return this;
        }
    }

}
