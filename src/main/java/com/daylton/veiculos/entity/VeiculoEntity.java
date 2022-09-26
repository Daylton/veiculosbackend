package com.daylton.veiculos.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "veiculos")
public class VeiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String veiculo;
    private String marca;
    private int ano;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private boolean vendido;
    private LocalDateTime created;
    private LocalDateTime updated;

    public VeiculoEntity() {
    }

    public VeiculoEntity(long id, String veiculo, String marca, int ano, String descricao, boolean vendido,
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
