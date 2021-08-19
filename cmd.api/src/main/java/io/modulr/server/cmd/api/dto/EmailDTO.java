package io.modulr.server.cmd.api.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EmailDTO {
    private Long id;
    @NotEmpty
    private String subject;
    @NotEmpty
    private String message;
}
