package io.modulr.server.cmd.api.dataaccess.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@ToString
public class Email {
    @Id
    @Column(name = "id", columnDefinition = "uuid")

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "id",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;



    @Column(name="subject")
    private String subject;

    @Column(name = "message")
    private String message;

    @Version
    @Column(name = "version")
    private int version;

    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @PrePersist
    protected void onCreate()
    {
        this.createdDate = LocalDateTime.now();
    }
}
