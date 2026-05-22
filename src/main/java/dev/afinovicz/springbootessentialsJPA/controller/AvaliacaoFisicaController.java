package dev.afinovicz.springbootessentialsJPA.controller;

import dev.afinovicz.springbootessentialsJPA.dto.AvaliacaoFisicaDTO;
import dev.afinovicz.springbootessentialsJPA.dto.AvaliacoesFisicasProjection;
import dev.afinovicz.springbootessentialsJPA.exception.BadRequestException;
import dev.afinovicz.springbootessentialsJPA.exception.NotFoundException;
import dev.afinovicz.springbootessentialsJPA.service.AvaliacaoFisicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void criarAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDTO avaliacaoFisicaDTO) throws NotFoundException, BadRequestException {
        avaliacaoFisicaService.criarAvaliacaoFisica(avaliacaoFisicaDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AvaliacoesFisicasProjection> getAllAvaliacoes() {
        return avaliacaoFisicaService.getAllAvaliacoes();
    }

    @GetMapping("page/{page}/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public Page<AvaliacoesFisicasProjection> getAllAvaliacoesFisicasPageable(@PathVariable Integer page, @PathVariable Integer size) {
        return avaliacaoFisicaService.getAllAvaliacoesPageble(page, size);
    }


}
