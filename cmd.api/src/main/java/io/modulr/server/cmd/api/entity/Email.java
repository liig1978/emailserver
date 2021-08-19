package io.modulr.server.cmd.api.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@ToString
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="subject", nullable = false)
    private String subject;

    @Column(name = "message", nullable = false)
    private String message;

    @Version
    @Column(name = "version", nullable = false)
    private int version;

    @Column(name = "create_date", updatable = false)
    private LocalDateTime createdDate;

    @PrePersist
    protected void onCreate()
    {
        this.createdDate = LocalDateTime.now();
    }
}
