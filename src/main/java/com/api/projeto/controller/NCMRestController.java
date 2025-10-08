package com.api.projeto.controller;

import com.api.projeto.entity.NCM;
import com.api.projeto.service.NCMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ncm") // Endpoint base
public class NCMRestController {

    @Autowired
    private NCMService ncmService;

    @GetMapping
    public List<NCM> listar() {
        return ncmService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<NCM> salvar(@RequestBody NCM ncm) {
        NCM novoNCM = ncmService.salvar(ncm);
        return ResponseEntity.ok(novoNCM);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (ncmService.buscarPorId(id).isPresent()) {
            ncmService.excluir(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}