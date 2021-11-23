package com.switchfully.order.api.customers.emails;

import com.switchfully.order.domain.customers.emails.Email;
import com.switchfully.order.infrastructure.dto.Mapper;
import org.springframework.stereotype.Component;

import javax.inject.Named;

import static com.switchfully.order.domain.customers.emails.Email.EmailBuilder.email;

@Component
public class EmailMapper extends Mapper<EmailDto, Email> {

    @Override
    public EmailDto toDto(Email email) {
        return new EmailDto()
                .withLocalPart(email.getLocalPart())
                .withDomain(email.getDomain())
                .withComplete(email.getComplete());
    }

    @Override
    public Email toDomain(EmailDto emailDto) {
        return email()
                .withLocalPart(emailDto.getLocalPart())
                .withDomain(emailDto.getDomain())
                .withComplete(emailDto.getComplete())
                .build();
    }
}
