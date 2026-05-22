package dev.afinovicz.springbootessentialsJPA.controller;

import dev.afinovicz.springbootessentialsJPA.database.model.AvaliacoesFisicasEntity;
import dev.afinovicz.springbootessentialsJPA.dto.AlunoDTO;
import dev.afinovicz.springbootessentialsJPA.exception.BadRequestException;
import dev.afinovicz.springbootessentialsJPA.exception.NotFoundException;
import dev.afinovicz.springbootessentialsJPA.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunosController {

    private final AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunoDTO alunoDTO) throws BadRequestException {
        alunoService.criarAluno(alunoDTO);
    }

    @GetMapping("/{alunoId}/avaliacao")
    @ResponseStatus(HttpStatus.OK)
    public AvaliacoesFisicasEntity getAvaliacaoFisicaById(@PathVariable Integer alunoId) throws NotFoundException {
        return alunoService.avaliacaoFisicaDoAluno(alunoId);
    }

}
