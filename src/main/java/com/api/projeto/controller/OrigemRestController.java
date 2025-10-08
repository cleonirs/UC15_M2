package com.api.projeto.controller;

import com.api.projeto.entity.Origem;
import com.api.projeto.service.OrigemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/origem") // Endpoint base
public class OrigemRestController {

    @Autowired
    private OrigemService origemService;

    @GetMapping
    public List<Origem> listar() {
        return origemService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Origem> salvar(@RequestBody Origem origem) {
        Origem novaOrigem = origemService.salvar(origem);
        return ResponseEntity.ok(novaOrigem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (origemService.buscarPorId(id).isPresent()) {
            origemService.excluir(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}