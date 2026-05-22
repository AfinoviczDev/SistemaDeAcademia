package dev.afinovicz.springbootessentialsJPA.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_avaliacoes_fisicas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AvaliacoesFisicasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "peso", nullable = false)
    private BigDecimal peso;
    @Column(name = "altura", nullable = false)
    private BigDecimal altura;
    @Column(name = "porcentagem_gordura_corporal", nullable = false)
    private BigDecimal porcentagemGorduraCorporal;

}
