package com.api.projeto.controller;

import com.api.projeto.entity.ICMS;
import com.api.projeto.service.ICMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/icms") // Endpoint base
public class ICMSRestController {

    @Autowired
    private ICMSService icmsService;

    // GET: Listar todos
    @GetMapping
    public List<ICMS> listar() {
        return icmsService.listarTodos();
    }

    // POST: Cadastrar novo ou PUT: Atualizar
    @PostMapping
    public ResponseEntity<ICMS> salvar(@RequestBody ICMS icms) {
        ICMS novoICMS = icmsService.salvar(icms);
        return ResponseEntity.ok(novoICMS);
    }

    // GET: Buscar por ID (Adicionado para completar o CRUD)
    @GetMapping("/{id}")
    public ResponseEntity<ICMS> buscarPorId(@PathVariable Long id) {
        return icmsService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE: Excluir por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (icmsService.buscarPorId(id).isPresent()) {
            icmsService.excluir(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}