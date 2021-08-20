package io.modulr.server.cmd.api.controller;

import io.modulr.server.cmd.api.dataaccess.dto.EmailDTO;
import io.modulr.server.cmd.api.facade.EmailFacade;
import io.modulr.server.cmd.api.service.EmailService;
import io.modulr.server.cmd.api.validations.ResponseErrorValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/api/email", produces = "application/vnd.api.v1+json")
public class EmailController {

    private final EmailFacade emailFacade;
    private final EmailService emailService;
    //private final ResponseErrorValidation responseErrorValidation;

    @Autowired
    public EmailController(EmailFacade emailFacade,
                           EmailService emailService) {
        this.emailFacade = emailFacade;
        this.emailService = emailService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createEmail(@Valid @RequestBody EmailDTO emailDTO) {


        var email =emailService.createEmail(emailDTO);
        var createdEmail = emailFacade.emailToEmailDTO(email);

        return new ResponseEntity<>(createdEmail, HttpStatus.CREATED);
    }
}
