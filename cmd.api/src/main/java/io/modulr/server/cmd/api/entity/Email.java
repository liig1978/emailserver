package io.modulr.server.cmd.api.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
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
}
