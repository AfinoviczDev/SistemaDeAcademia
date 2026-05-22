package dev.afinovicz.springbootessentialsJPA.service;

import dev.afinovicz.springbootessentialsJPA.database.model.ExerciciosEntity;
import dev.afinovicz.springbootessentialsJPA.database.repository.ExerciciosRepository;
import dev.afinovicz.springbootessentialsJPA.dto.ExerciciosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciciosService {

    private final ExerciciosRepository exerciciosRepository;

    public List<ExerciciosEntity> findAll() {
        return  exerciciosRepository.findAll();
    }

    public void save(ExerciciosDTO exerciciosDTO) {
        exerciciosRepository.save(ExerciciosEntity.builder()
                        .nome(exerciciosDTO.nome())
                        .grupoMuscular(exerciciosDTO.grupoMuscular())
                .build());
    }

    public List<ExerciciosEntity> getExerciciosByGrupoMuscular(String grupoMuscular) {
        return exerciciosRepository.findAllByGrupoMuscular(grupoMuscular);
    }
}
