package br.paulocalderan.tinnova.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoResponse {

    private String nome;
    private String marca;
    private Integer ano;
    private String descricao;
    private boolean vendido;
    private String cor;

}