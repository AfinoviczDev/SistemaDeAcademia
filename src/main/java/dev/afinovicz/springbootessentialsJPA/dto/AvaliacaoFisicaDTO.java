package dev.afinovicz.springbootessentialsJPA.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AvaliacaoFisicaDTO(@NotNull Integer alunoId, @NotNull BigDecimal peso,
                                 @NotNull BigDecimal altura,@NotNull BigDecimal porcentagemGorduraCorporal) {
}
