package dev.afinovicz.springbootessentialsJPA.database.repository;

import dev.afinovicz.springbootessentialsJPA.database.model.AvaliacoesFisicasEntity;
import dev.afinovicz.springbootessentialsJPA.dto.AvaliacoesFisicasProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.List;

public interface AvaliacoesFisicasRepository extends JpaRepository<AvaliacoesFisicasEntity, Integer> {

    @NativeQuery(value = """
        SELECT a.id                             idAluno,
               a.nome                           nomeAluno,
               af.id                            idAvaliacao, 
               af.peso                          peso,
               af.altura                        altura,
               af.porcentagem_gordura_corporal   porcentagemGorduraCorporal
        FROM tb_avaliacoes_fisicas af
        INNER JOIN tb_alunos a
        ON a.avaliacao_fisica_id = af.id
        """)
    List<AvaliacoesFisicasProjection> getAllAvaliacoes();

    @NativeQuery(value = """
        SELECT a.id                             idAluno,
               a.nome                           nomeAluno,
               af.id                            idAvaliacao, 
               af.peso                          peso,
               af.altura                        altura,
               af.porcentagem_gordura_corporal   porcentagemGorduraCorporal
        FROM tb_avaliacoes_fisicas af
        INNER JOIN tb_alunos a
        ON a.avaliacao_fisica_id = af.id
        """,
    countQuery = """
        SELECT count(af.id)
        FROM tb_avaliacoes_fisicas af
        INNER JOIN tb_alunos a
        ON a.avaliacao_fisica_id = af.id
        """ )
    Page<AvaliacoesFisicasProjection> getAllAvaliacoesPage(Pageable pageable);


}
