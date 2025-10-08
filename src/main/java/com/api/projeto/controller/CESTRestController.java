package com.api.projeto.controller;

import com.api.projeto.entity.CEST;
import com.api.projeto.service.CESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cest") // Endpoint base
public class CESTRestController {

    @Autowired
    private CESTService cestService;

    @GetMapping
    public List<CEST> listar() {
        return cestService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<CEST> salvar(@RequestBody CEST cest) {
        CEST novoCEST = cestService.salvar(cest);
        return ResponseEntity.ok(novoCEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (cestService.buscarPorId(id).isPresent()) {
            cestService.excluir(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}