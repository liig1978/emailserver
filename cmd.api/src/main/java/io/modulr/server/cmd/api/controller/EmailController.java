package io.modulr.server.cmd.api.controller;

import io.modulr.server.cmd.api.dto.EmailDTO;
import io.modulr.server.cmd.api.facade.EmailFacade;
import io.modulr.server.cmd.api.service.EmailService;
import io.modulr.server.cmd.api.validations.ResponseErrorValidation;
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

@RestController
@RequestMapping("api/email")
public class EmailController {

    private EmailFacade emailFacade;
    private EmailService emailService;
    private ResponseErrorValidation responseErrorValidation;

    @Autowired
    public EmailController(EmailFacade emailFacade,
                           EmailService emailService,
                           ResponseErrorValidation responseErrorValidation) {
        this.emailFacade = emailFacade;
        this.emailService = emailService;
        this.responseErrorValidation = responseErrorValidation;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createEmail(@Valid @RequestBody EmailDTO emailDTO,
                                              BindingResult bindingResult) {
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errors)) return errors;

        var email =emailService.createEmail(emailDTO);
        var createdEmail = emailFacade.emailToEmailDTO(email);

        return new ResponseEntity<>(createdEmail, HttpStatus.CREATED);
    }
}
