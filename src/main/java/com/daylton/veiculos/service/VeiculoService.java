package com.daylton.veiculos.service;

import com.daylton.veiculos.model.VeiculoModel;

import java.util.List;

public interface VeiculoService {


    VeiculoModel saveVeiculo(VeiculoModel veiculoModel);

    List<VeiculoModel> getAllVeiculos();

    VeiculoModel getVeiculoById(Long id);

    boolean deleteVeiculo(Long id);

    VeiculoModel updateVeiculo(Long id, VeiculoModel veiculoModel);
}
