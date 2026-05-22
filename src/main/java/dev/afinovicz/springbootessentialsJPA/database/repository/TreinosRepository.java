package dev.afinovicz.springbootessentialsJPA.database.repository;

import dev.afinovicz.springbootessentialsJPA.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TreinosRepository extends JpaRepository<TreinosEntity, Integer> {

    Optional<TreinosEntity> findByNomeAndAlunoId(String nome, Integer alunoId);
}
