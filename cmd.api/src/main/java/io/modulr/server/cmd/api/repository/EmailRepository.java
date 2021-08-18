package io.modulr.server.cmd.api.repository;

import io.modulr.server.cmd.api.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findAll();

    Email getById(Long id);
}
