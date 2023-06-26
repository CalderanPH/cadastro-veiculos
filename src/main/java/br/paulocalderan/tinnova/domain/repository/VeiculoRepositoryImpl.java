package br.paulocalderan.tinnova.domain.repository;

import br.paulocalderan.tinnova.domain.Veiculo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static br.paulocalderan.tinnova.exception.ExceptionConstants.VEICULO_NAO_ENCONTRADO;

/**
 * Implementação da interface de repositório para a entidade Veiculo.
 */
@Repository
@RequiredArgsConstructor
public class VeiculoRepositoryImpl implements VeiculoRepository {

    private final VeiculoRepositoryJpa veiculoRepositoryJpa;

    @Override
    public Veiculo save(Veiculo veiculo) {
        return veiculoRepositoryJpa.save(veiculo);
    }

    @Override
    public Veiculo findBy(UUID id) {
        return veiculoRepositoryJpa
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(VEICULO_NAO_ENCONTRADO));
    }

    @Override
    public List<Veiculo> findAllVeiculos() {
        return veiculoRepositoryJpa.findAll();
    }

    @Override
    public void delete(UUID id) {
        Veiculo veiculo = findBy(id);
        veiculoRepositoryJpa.delete(veiculo);
    }

    @Override
    public List<Veiculo> findByFilter(String marca, Integer ano, String cor) {
        return veiculoRepositoryJpa.findByFilters(marca, ano, cor);
    }

    @Override
    public List<Veiculo> findAllNotVendido() {
        return veiculoRepositoryJpa.findAllNotSold();
    }

    @Override
    public List<Veiculo> findAllDecada(Integer inicioDecada, Integer inicioProximaDecada) {
        return veiculoRepositoryJpa.findAllByDecada(inicioDecada, inicioProximaDecada);
    }

    @Override
    public List<Veiculo> findByMarca(String marca) {
        return veiculoRepositoryJpa.findAllByMarca(marca);
    }

    @Override
    public List<Veiculo> findAllByCreatedAfter(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return veiculoRepositoryJpa.findRecordLastWeek(dataInicio, dataFim);
    }

}