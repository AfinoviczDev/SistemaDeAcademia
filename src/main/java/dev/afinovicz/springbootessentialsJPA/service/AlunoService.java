package dev.afinovicz.springbootessentialsJPA.service;

import dev.afinovicz.springbootessentialsJPA.database.model.AlunosEntity;
import dev.afinovicz.springbootessentialsJPA.database.model.AvaliacoesFisicasEntity;
import dev.afinovicz.springbootessentialsJPA.database.model.TreinosEntity;
import dev.afinovicz.springbootessentialsJPA.database.repository.AlunosRepository;
import dev.afinovicz.springbootessentialsJPA.database.repository.AvaliacoesFisicasRepository;
import dev.afinovicz.springbootessentialsJPA.database.repository.TreinosRepository;
import dev.afinovicz.springbootessentialsJPA.dto.AlunoDTO;
import dev.afinovicz.springbootessentialsJPA.exception.BadRequestException;
import dev.afinovicz.springbootessentialsJPA.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AvaliacoesFisicasRepository avaliacoesFisicasRepository;
    private final TreinosRepository treinosRepository;
    private final AlunosRepository alunosRepository;

    public void criarAluno(AlunoDTO alunoDTO) throws BadRequestException {
        AlunosEntity aluno = alunosRepository.findByEmail(alunoDTO.email())
                .orElse(null);
        if(aluno!=null) {
            throw new BadRequestException("Aluno já cadastrado com este EMAIL!");
        }
        alunosRepository.save(AlunosEntity.builder()
                        .nome(alunoDTO.nome())
                        .email(alunoDTO.email())
                .build());
    }

    public AvaliacoesFisicasEntity avaliacaoFisicaDoAluno(Integer alunoId) throws NotFoundException{
        AlunosEntity aluno = alunosRepository.findById(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado!"));

        AvaliacoesFisicasEntity avaliacao = aluno.getAvaliacaoFisica();
        if(avaliacao == null) {
            throw new NotFoundException("Avaliação fisica não encontrada para este aluno");
        }

        return avaliacao;
    }

    @Transactional
    //GARANTIR CONSISTENCIA DOS DADOS NA APLICAÇÃO, OU DELETA TUDO OU NAO FAZ NADA!
    public void deletarAluno(Integer alunoId) throws  NotFoundException{
        //1. deletar treinos do aluno
        AlunosEntity aluno = alunosRepository.findById(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado!"));
        List<Integer> treinosAlunosIds = aluno.getTreinos().stream()
                .map(TreinosEntity::getId)
                        .toList();

        treinosRepository.deleteAllById(treinosAlunosIds);

        //2. deletar o aluno
        alunosRepository.deleteById(alunoId);

        //3. deletar avaliacao fisica
        avaliacoesFisicasRepository.deleteById(aluno.getAvaliacaoFisica().getId());

        alunosRepository.deleteById(alunoId);
    }
}
