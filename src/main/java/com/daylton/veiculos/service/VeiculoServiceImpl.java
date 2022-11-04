package com.daylton.veiculos.service;

import com.daylton.veiculos.entity.VeiculoEntity;
import com.daylton.veiculos.model.VeiculoModel;
import com.daylton.veiculos.repository.VeiculoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public VeiculoModel saveVeiculo(VeiculoModel veiculoModel) {
        VeiculoEntity veiculoEntity = new VeiculoEntity();
        veiculoModel.setCreated(LocalDateTime.now());
        BeanUtils.copyProperties(veiculoModel, veiculoEntity);
        veiculoRepository.save(veiculoEntity);
        return veiculoModel;
    }

    @Override
    public List<VeiculoModel> getAllVeiculos() {
        List<VeiculoEntity> veiculoEntities = veiculoRepository.findAll();

        List<VeiculoModel> veiculos = veiculoEntities
                .stream()
                .map(veiculoEntity -> new VeiculoModel(
                        veiculoEntity.getId(),
                        veiculoEntity.getVeiculo(),
                        veiculoEntity.getMarca(),
                        veiculoEntity.getAno(),
                        veiculoEntity.getDescricao(),
                        veiculoEntity.getCreated(),
                        veiculoEntity.getUpdated()
                ))
                .collect(Collectors.toList());


        return veiculos;
    }

    @Override
    public VeiculoModel getVeiculoById(Long id) {

        VeiculoEntity veiculoEntity
                = veiculoRepository.findById(id).get();
        VeiculoModel veiculoModel = new VeiculoModel();
        BeanUtils.copyProperties(veiculoEntity, veiculoModel);

        return veiculoModel;
    }

    @Override
    public boolean deleteVeiculo(Long id) {

        VeiculoEntity veiculo = veiculoRepository.findById(id).get();
        veiculoRepository.delete(veiculo);

        return true;
    }

    @Override
    public VeiculoModel updateVeiculo(Long id, VeiculoModel veiculoModel) {
        VeiculoEntity veiculoEntity =
                veiculoRepository.findById(id).get();
        veiculoModel.setUpdated(LocalDateTime.now());
        veiculoEntity.setVeiculo(veiculoModel.getVeiculo());
        veiculoEntity.setMarca(veiculoModel.getMarca());
        veiculoEntity.setAno(veiculoModel.getAno());
        veiculoEntity.setDescricao(veiculoModel.getDescricao());
        veiculoEntity.setUpdated(veiculoModel.getUpdated());

        veiculoRepository.save(veiculoEntity);

        return veiculoModel;
    }


}

























