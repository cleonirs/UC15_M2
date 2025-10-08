package com.api.projeto.controller;

import com.api.projeto.entity.CST;
import com.api.projeto.service.CSTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cst") // Endpoint base
public class CSTRestController {

    @Autowired
    private CSTService cstService;

    @GetMapping
    public List<CST> listar() {
        return cstService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<CST> salvar(@RequestBody CST cst) {
        CST novoCST = cstService.salvar(cst);
        return ResponseEntity.ok(novoCST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (cstService.buscarPorId(id).isPresent()) {
            cstService.excluir(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}