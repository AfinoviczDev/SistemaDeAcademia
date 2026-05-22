package dev.afinovicz.springbootessentialsJPA.service;

import dev.afinovicz.springbootessentialsJPA.database.model.AlunosEntity;
import dev.afinovicz.springbootessentialsJPA.database.model.ExerciciosEntity;
import dev.afinovicz.springbootessentialsJPA.database.model.TreinosEntity;
import dev.afinovicz.springbootessentialsJPA.database.repository.AlunosRepository;
import dev.afinovicz.springbootessentialsJPA.database.repository.ExerciciosRepository;
import dev.afinovicz.springbootessentialsJPA.database.repository.TreinosRepository;
import dev.afinovicz.springbootessentialsJPA.dto.TreinoDTO;
import dev.afinovicz.springbootessentialsJPA.exception.BadRequestException;
import dev.afinovicz.springbootessentialsJPA.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final AlunosRepository alunosRepository;
    private final ExerciciosRepository exerciciosRepository;
    private final TreinosRepository treinosRepository;

    public void criarTreino(TreinoDTO treinoDTO) throws NotFoundException, BadRequestException {
        Set<ExerciciosEntity> exercicios = new HashSet<>();

        AlunosEntity aluno = alunosRepository.findById(treinoDTO.alunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado!"));
        TreinosEntity treino = treinosRepository.findByNomeAndAlunoId(treinoDTO.name(), treinoDTO.alunoId())
                .orElse(null);
        if(treino!= null) {
            throw new BadRequestException("Já existe um treino com esse nome para esse aluno!");
        }

        for (Integer exercicioId : treinoDTO.exerciciosIds()) {
            ExerciciosEntity exercicio = exerciciosRepository.findById(exercicioId)
                    .orElseThrow(() -> new NotFoundException(String.format("Exercício %s não encontrado!", exercicioId)));
            exercicios.add(exercicio);
        }
        treino = TreinosEntity.builder()
                .nome(treinoDTO.name())
                .aluno(aluno)
                .exercicios(exercicios)
                .build();
        treinosRepository.save(treino);
    }

}
