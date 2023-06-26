package br.paulocalderan.tinnova.domain.service;

import br.paulocalderan.tinnova.domain.Veiculo;
import br.paulocalderan.tinnova.domain.assembler.VeiculoAssembler;
import br.paulocalderan.tinnova.domain.dto.request.VeiculoRequest;
import br.paulocalderan.tinnova.domain.dto.request.VeiculoRequestStatus;
import br.paulocalderan.tinnova.domain.dto.response.VeiculoResponse;
import br.paulocalderan.tinnova.domain.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import static br.paulocalderan.tinnova.domain.enums.FabricanteVeiculoEnum.isValid;

/**
 * Classe de serviço para gerenciar entidades Veiculo.
 */
@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<VeiculoResponse> findAll() {
        List<Veiculo> veiculos = veiculoRepository.findAllVeiculos();
        return VeiculoAssembler.toListResponseModel(veiculos);
    }

    /**
     * Recupera veículos por filtro.
     *
     * @param marca a marca dos veículos a serem recuperados
     * @param ano   o ano dos veículos a serem recuperados
     * @param cor   a cor dos veículos a serem recuperados
     * @return Lista de modelos de resposta de veículo
     */
    public List<VeiculoResponse> obterVeiculosPorFiltro(String marca, Integer ano, String cor) {
        List<Veiculo> veiculos = veiculoRepository.findByFilter(marca, ano, cor);
        return VeiculoAssembler.toListResponseModel(veiculos);
    }

    public VeiculoResponse findById(UUID id) {
        Veiculo veiculo = veiculoRepository.findBy(id);
        return VeiculoAssembler.toResponseModel(veiculo);
    }

    public Veiculo criar(VeiculoRequest request) {
        isValid(request.getMarca());
        Veiculo veiculo = VeiculoAssembler.toEntity(request);
        return veiculoRepository.save(veiculo);
    }

    public void atualizar(UUID id, VeiculoRequest request) {
        isValid(request.getMarca());
        Veiculo veiculo = veiculoRepository.findBy(id);
        veiculo.setVendido(request.isVendido());
        veiculo.setAno(request.getAno());
        veiculo.setMarca(request.getMarca());
        veiculo.setNome(request.getNome());
        veiculo.setDescricao(request.getDescricao());
        veiculo.setUpdated(LocalDateTime.now());
        veiculo.setCor(request.getCor());
        veiculoRepository.save(veiculo);
        VeiculoAssembler.toResponseModel(veiculo);
    }

    public void delete(UUID id) {
        veiculoRepository.delete(id);
    }

    public void atualizarStatus(UUID id, VeiculoRequestStatus veiculoRequest) {
        Veiculo veiculo = veiculoRepository.findBy(id);
        veiculo.setVendido(veiculoRequest.isVendido());
        veiculoRepository.save(veiculo);
    }

    public List<VeiculoResponse> obterVeiculosNaoVendidos() {
        List<Veiculo> veiculos = veiculoRepository.findAllNotVendido();
        return VeiculoAssembler.toListResponseModel(veiculos);
    }

    /**
     * Recupera os veículos de uma década específica.
     *
     * @param ano o ano da década
     * @return Lista de modelos de resposta de veículo
     */
    public List<VeiculoResponse> obterVeiculosDecada(Integer ano) {
        int inicioDecada = ano / 10 * 10;
        int inicioProximaDecada = inicioDecada + 10;
        List<Veiculo> veiculos = veiculoRepository.findAllDecada(inicioDecada, inicioProximaDecada);
        return VeiculoAssembler.toListResponseModel(veiculos);
    }


    public List<VeiculoResponse> obterVeiculosPorMarca(String marca) {
        List<Veiculo> veiculos = veiculoRepository.findByMarca(marca);
        return VeiculoAssembler.toListResponseModel(veiculos);
    }

    public List<VeiculoResponse> obterVeiculosUltimaSemana() {
        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataInicio = dataAtual.minusDays(7).with(LocalTime.MIN);
        LocalDateTime dataFim = dataAtual.with(LocalTime.MAX);
        List<Veiculo> veiculos = veiculoRepository.findAllByCreatedAfter(dataInicio, dataFim);
        return VeiculoAssembler.toListResponseModel(veiculos);
    }

}