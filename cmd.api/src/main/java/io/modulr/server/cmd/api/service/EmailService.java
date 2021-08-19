package io.modulr.server.cmd.api.service;

import io.modulr.server.cmd.api.dto.EmailDTO;
import io.modulr.server.cmd.api.entity.Email;
import io.modulr.server.cmd.api.repository.EmailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {
    private final EmailRepository emailRepository;

    @Autowired
    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public Email createEmail(EmailDTO emailDTO) {
        var email = new Email();
        email.setSubject(emailDTO.getSubject());
        email.setMessage(emailDTO.getMessage());

        log.info("Saving Email {}", email.toString());
        return emailRepository.save(email);
    }
}
