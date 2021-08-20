package io.modulr.server.cmd.api.dataaccess.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
public class EmailDTO {
    private UUID id;
    @NotEmpty
    private String subject;
    @NotEmpty
    private String message;
}
