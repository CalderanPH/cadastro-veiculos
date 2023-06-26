package br.paulocalderan.tinnova.domain.dto.request;

import lombok.Data;

@Data
public class VeiculoRequest {

    private String nome;
    private String marca;
    private Integer ano;
    private String descricao;
    private boolean vendido;
    private String cor;

}