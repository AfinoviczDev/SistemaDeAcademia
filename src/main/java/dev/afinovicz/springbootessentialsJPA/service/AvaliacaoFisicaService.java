package dev.afinovicz.springbootessentialsJPA.service;

import dev.afinovicz.springbootessentialsJPA.database.model.AlunosEntity;
import dev.afinovicz.springbootessentialsJPA.database.model.AvaliacoesFisicasEntity;
import dev.afinovicz.springbootessentialsJPA.database.repository.AlunosRepository;
import dev.afinovicz.springbootessentialsJPA.database.repository.AvaliacoesFisicasRepository;
import dev.afinovicz.springbootessentialsJPA.dto.AvaliacaoFisicaDTO;
import dev.afinovicz.springbootessentialsJPA.dto.AvaliacoesFisicasProjection;
import dev.afinovicz.springbootessentialsJPA.exception.BadRequestException;
import dev.afinovicz.springbootessentialsJPA.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final AlunosRepository alunosRepository;
    private final AvaliacoesFisicasRepository avaliacoesFisicasRepository;

    public void criarAvaliacaoFisica(AvaliacaoFisicaDTO avaliacaoFisicaDTO) throws NotFoundException, BadRequestException {
        AlunosEntity aluno = alunosRepository.findById(avaliacaoFisicaDTO.alunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado!"));
        AvaliacoesFisicasEntity avaliacaoFisica = aluno.getAvaliacaoFisica();
        if(avaliacaoFisica != null) {
            throw new BadRequestException("Avaliação fisica já cadastrada para este aluno!");
        }

        avaliacaoFisica = AvaliacoesFisicasEntity.builder()
                .peso(avaliacaoFisicaDTO.peso())
                .altura(avaliacaoFisicaDTO.altura())
                .porcentagemGorduraCorporal(avaliacaoFisicaDTO.porcentagemGorduraCorporal())
                .build();

        // Não é necessário essa operação pois o @OneToOne esta com (cascade = CascadeType.ALL)
        //avaliacaoFisica = avaliacoesFisicasRepository.save(avaliacaoFisica);

        aluno.setAvaliacaoFisica(avaliacaoFisica);
        alunosRepository.save(aluno);
    }

    public List<AvaliacoesFisicasProjection> getAllAvaliacoes() {
        return avaliacoesFisicasRepository.getAllAvaliacoes();
    }

    public Page<AvaliacoesFisicasProjection> getAllAvaliacoesPageble(Integer page, Integer size) {
        return avaliacoesFisicasRepository.getAllAvaliacoesPage(PageRequest.of(page, size));
    }

}
