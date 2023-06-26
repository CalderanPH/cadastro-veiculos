package br.paulocalderan.tinnova.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_veiculo")
public class Veiculo {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String marca;
    private Integer ano;
    private String descricao;
    private boolean vendido;
    private String cor;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Veiculo(String nome, String marca, Integer ano, String descricao, boolean vendido, String cor) {
        this.nome = nome;
        this.marca = marca;
        this.ano = ano;
        this.descricao = descricao;
        this.vendido = vendido;
        this.cor = cor;
    }

    public Veiculo(UUID id, String nome, String marca, Integer ano, String descricao, boolean vendido, String cor) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.ano = ano;
        this.descricao = descricao;
        this.vendido = vendido;
        this.cor = cor;
    }
}