package io.modulr.server.cmd.api.facade;

import io.modulr.server.cmd.api.dto.EmailDTO;
import io.modulr.server.cmd.api.entity.Email;
import org.springframework.stereotype.Component;

@Component
public class EmailFacade {
    public EmailDTO emailToEmailDTO(Email email) {
        var emailDTO = new EmailDTO();
        emailDTO.setId(email.getId());
        emailDTO.setSubject(email.getSubject());
        emailDTO.setMessage(email.getMessage());
        return emailDTO;
    }
}
