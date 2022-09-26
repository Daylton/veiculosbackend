package com.daylton.veiculos.model;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class VeiculoModel {

    private long id;
    private String veiculo;
    private String marca;
    private int ano;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private boolean vendido;
    private LocalDateTime created;
    private LocalDateTime updated;

    public VeiculoModel() {
    }

    public VeiculoModel(long id, String veiculo, String marca, int ano, String descricao, boolean vendido,
                        LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.veiculo = veiculo;
        this.marca = marca;
        this.ano = ano;
        this.descricao = descricao;
        this.vendido = vendido;
        this.created = created;
        this.updated = updated;
    }
}
