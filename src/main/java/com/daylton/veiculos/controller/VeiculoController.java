package com.daylton.veiculos.controller;

import com.daylton.veiculos.model.VeiculoModel;
import com.daylton.veiculos.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping("")
    public VeiculoModel saveVeiculo(@RequestBody VeiculoModel veiculoModel) {
        return veiculoService.saveVeiculo(veiculoModel);
    }

    @GetMapping("")
    public List<VeiculoModel> getAllVeiculos() {
        return veiculoService.getAllVeiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoModel> getVeiculoById(@PathVariable("id") Long id) {
        VeiculoModel veiculoModel = null;
        veiculoModel = veiculoService.getVeiculoById(id);
        return ResponseEntity.ok(veiculoModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteVeiculo(@PathVariable("id") Long id) {
        boolean deleted = false;
        deleted = veiculoService.deleteVeiculo(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoModel> updateVeiculo(@PathVariable("id") Long id, @RequestBody VeiculoModel veiculoModel) {
        veiculoModel = veiculoService.updateVeiculo(id, veiculoModel);
        return ResponseEntity.ok(veiculoModel);
    }

}






















