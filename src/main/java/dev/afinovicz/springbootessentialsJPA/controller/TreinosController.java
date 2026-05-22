package dev.afinovicz.springbootessentialsJPA.controller;

import dev.afinovicz.springbootessentialsJPA.dto.TreinoDTO;
import dev.afinovicz.springbootessentialsJPA.exception.BadRequestException;
import dev.afinovicz.springbootessentialsJPA.exception.NotFoundException;
import dev.afinovicz.springbootessentialsJPA.service.TreinoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/treinos")
@RequiredArgsConstructor
public class TreinosController {

    private final TreinoService treinoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTreino(@Valid @RequestBody TreinoDTO treinoDTO) throws NotFoundException, BadRequestException {
        treinoService.criarTreino(treinoDTO);
    }
}
