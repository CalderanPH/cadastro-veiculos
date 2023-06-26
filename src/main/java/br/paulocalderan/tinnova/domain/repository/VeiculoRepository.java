package br.paulocalderan.tinnova.domain.repository;

import br.paulocalderan.tinnova.domain.Veiculo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface VeiculoRepository {

    Veiculo save(Veiculo veiculo);

    Veiculo findBy(UUID id);

    List<Veiculo> findAllVeiculos();

    void delete(UUID id);

    List<Veiculo> findByFilter(String marca, Integer ano, String cor);

    List<Veiculo> findAllNotVendido();

    List<Veiculo> findAllDecada(Integer inicioDecada, Integer inicioProximaDecada);

    List<Veiculo> findByMarca(String marca);

    List<Veiculo> findAllByCreatedAfter(LocalDateTime dataInicio, LocalDateTime dataFim);

}