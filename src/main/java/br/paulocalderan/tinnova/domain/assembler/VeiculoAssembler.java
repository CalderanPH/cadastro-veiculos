package br.paulocalderan.tinnova.domain.assembler;

import br.paulocalderan.tinnova.domain.Veiculo;
import br.paulocalderan.tinnova.domain.dto.request.VeiculoRequest;
import br.paulocalderan.tinnova.domain.dto.response.VeiculoResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Classe responsável por converter objetos entre a entidade Veiculo, a requisição VeiculoRequest
 * e a resposta VeiculoResponse.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VeiculoAssembler {

    public static Veiculo toEntity(VeiculoRequest request) {
        return new Veiculo(request.getNome(), request.getMarca(), request.getAno(), request.getDescricao(),
                request.isVendido(), request.getCor());
    }

    public static VeiculoResponse toResponseModel(Veiculo veiculo) {
        return new VeiculoResponse(veiculo.getNome(), veiculo.getMarca(), veiculo.getAno(), veiculo.getDescricao(),
                veiculo.isVendido(), veiculo.getCor());
    }

    public static List<VeiculoResponse> toListResponseModel(List<Veiculo> veiculoList) {
        return veiculoList.stream()
                .map(veiculo -> {
                    VeiculoResponse veiculoResponse = new VeiculoResponse();
                    veiculoResponse.setAno(veiculo.getAno());
                    veiculoResponse.setNome(veiculo.getNome());
                    veiculoResponse.setDescricao(veiculo.getDescricao());
                    veiculoResponse.setVendido(veiculo.isVendido());
                    veiculoResponse.setMarca(veiculo.getMarca());
                    veiculoResponse.setCor(veiculo.getCor());

                    return veiculoResponse;
                })
                .toList();
    }

}