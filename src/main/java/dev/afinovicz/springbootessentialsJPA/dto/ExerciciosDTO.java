package dev.afinovicz.springbootessentialsJPA.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record ExerciciosDTO(@NotBlank String nome,@NotBlank String grupoMuscular) {
}
