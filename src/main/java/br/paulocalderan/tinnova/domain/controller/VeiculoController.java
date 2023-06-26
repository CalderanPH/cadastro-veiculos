package br.paulocalderan.tinnova.domain.controller;

import br.paulocalderan.tinnova.domain.Veiculo;
import br.paulocalderan.tinnova.domain.dto.request.VeiculoRequest;
import br.paulocalderan.tinnova.domain.dto.request.VeiculoRequestStatus;
import br.paulocalderan.tinnova.domain.dto.response.VeiculoResponse;
import br.paulocalderan.tinnova.domain.service.VeiculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @GetMapping
    public List<VeiculoResponse> findAll() {
        return veiculoService.findAll();
    }

    @GetMapping("/filter")
    public List<VeiculoResponse> getVeiculosByFilter(@RequestParam(required = false) String marca,
                                                     @RequestParam(required = false) Integer ano,
                                                     @RequestParam(required = false) String cor) {
        return veiculoService.obterVeiculosPorFiltro(marca, ano, cor);
    }

    @GetMapping("/{id}")
    public VeiculoResponse getVeiculoById(@PathVariable UUID id) {
        return veiculoService.findById(id);
    }

    @GetMapping("/nao-vendidos")
    public List<VeiculoResponse> getVeiculosNaoVendidos() {
        return veiculoService.obterVeiculosNaoVendidos();
    }

    @GetMapping("/decada")
    public List<VeiculoResponse> getByDecada(@RequestParam("ano") Integer ano) {
        return veiculoService.obterVeiculosDecada(ano);
    }

    @GetMapping("/marca/{marca}")
    public List<VeiculoResponse> getVeiculosByMarca(@PathVariable String marca) {
        return veiculoService.obterVeiculosPorMarca(marca);
    }

    @GetMapping("/ultima-semana")
    public List<VeiculoResponse> getVeiculosUltimaSemana() {
        return veiculoService.obterVeiculosUltimaSemana();
    }

    @PostMapping
    public ResponseEntity<VeiculoResponse> create(@Valid @RequestBody VeiculoRequest request) {
        Veiculo veiculo = veiculoService.criar(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(veiculo.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateStatus(@PathVariable UUID id, @Valid @RequestBody VeiculoRequest request) {
        veiculoService.atualizar(id, request);
    }

    @PatchMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateStatus(@PathVariable UUID id, @Valid @RequestBody VeiculoRequestStatus request) {
        veiculoService.atualizarStatus(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        veiculoService.delete(id);
    }

}