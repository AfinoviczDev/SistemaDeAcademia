package dev.afinovicz.springbootessentialsJPA.controller;

import dev.afinovicz.springbootessentialsJPA.database.model.ExerciciosEntity;
import dev.afinovicz.springbootessentialsJPA.dto.ExerciciosDTO;
import dev.afinovicz.springbootessentialsJPA.service.ExerciciosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/exercicios")
@RequiredArgsConstructor
public class ExerciciosController {

    private final ExerciciosService exerciciosService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> findAll() {
        return exerciciosService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody ExerciciosDTO exerciciosDTO) {
       exerciciosService.save(exerciciosDTO);
    }

    @GetMapping("/grupos/{grupoMuscular}")
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> getExerciciosByGrupoMuscular(@PathVariable String grupoMuscular) {
        return exerciciosService.getExerciciosByGrupoMuscular(grupoMuscular);
    }
}
