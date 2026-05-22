package dev.afinovicz.springbootessentialsJPA.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TreinoDTO(@NotNull Integer alunoId, @NotBlank String name, @NotEmpty List<Integer> exerciciosIds) {
}
