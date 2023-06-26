package br.paulocalderan.tinnova.domain.repository;

import br.paulocalderan.tinnova.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Interface de repositório JPA para a entidade Veiculo.
 */
public interface VeiculoRepositoryJpa extends JpaRepository<Veiculo, UUID> {


    /**
     * Busca veículos de acordo com os critérios de marca, ano e cor.
     *
     * @param marca a marca do veículo (opcional)
     * @param ano   o ano do veículo (opcional)
     * @param cor   a cor do veículo (opcional)
     * @return uma lista de veículos filtrados
     */
    @Query("SELECT v FROM Veiculo v WHERE " +
            "(COALESCE(:marca, '') = '' OR v.marca = :marca) " +
            "AND (COALESCE(:ano, 0) = 0 OR v.ano = :ano) " +
            "AND (COALESCE(:cor, '') = '' OR v.cor = :cor)")
    List<Veiculo> findByFilters(@Param("marca") String marca, @Param("ano") Integer ano, @Param("cor") String cor);

    @Query("SELECT v FROM Veiculo v WHERE v.vendido = false")
    List<Veiculo> findAllNotSold();

    @Query("SELECT v FROM Veiculo v WHERE v.ano >= :inicioDecada AND v.ano < :inicioProximaDecada")
    List<Veiculo> findAllByDecada(@Param("inicioDecada") Integer inicioDecada, @Param("inicioProximaDecada") Integer inicioProximaDecada);

    @Query("SELECT v FROM Veiculo v WHERE v.marca = :marca")
    List<Veiculo> findAllByMarca(@Param("marca") String marca);

    @Query("SELECT v FROM Veiculo v WHERE v.created BETWEEN :dataInicio AND :dataFim")
    List<Veiculo> findRecordLastWeek(@Param("dataInicio") LocalDateTime dataInicio, @Param("dataFim") LocalDateTime dataFim);

}