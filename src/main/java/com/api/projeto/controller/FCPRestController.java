package com.api.projeto.controller;

import com.api.projeto.entity.FCP;
import com.api.projeto.service.FCPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fcp")
public class FCPRestController {

    @Autowired
    private FCPService fcpService;

    @GetMapping
    public List<FCP> listar() {
        return fcpService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<FCP> salvar(@RequestBody FCP fcp) {
        FCP novoFCP = fcpService.salvar(fcp);
        return ResponseEntity.ok(novoFCP);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (fcpService.buscarPorId(id).isPresent()) {
            fcpService.excluir(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
