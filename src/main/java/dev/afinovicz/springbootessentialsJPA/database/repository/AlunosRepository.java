package dev.afinovicz.springbootessentialsJPA.database.repository;

import dev.afinovicz.springbootessentialsJPA.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunosRepository extends JpaRepository<AlunosEntity, Integer> {

    Optional<AlunosEntity> findByEmail(String email);

}
