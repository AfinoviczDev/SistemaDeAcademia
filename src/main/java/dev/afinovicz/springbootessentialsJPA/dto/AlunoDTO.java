package dev.afinovicz.springbootessentialsJPA.dto;

import jakarta.validation.constraints.NotBlank;

public record AlunoDTO(@NotBlank String nome,@NotBlank String email) {
}
