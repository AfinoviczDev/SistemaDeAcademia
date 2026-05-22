package dev.afinovicz.springbootessentialsJPA.dto;

import java.math.BigDecimal;

public interface AvaliacoesFisicasProjection{

    Integer getIdAluno();
    String getNomeAluno();
    Integer getIdAvaliacao();
    BigDecimal getPeso();
    BigDecimal getAltura();
    BigDecimal getPorcentagemGorduraCorporal();
}
