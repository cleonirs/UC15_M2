package com.api.projeto.controller;

import com.api.projeto.entity.PISCOFINS;
import com.api.projeto.service.PISCOFINSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/piscofins") // Endpoint base
public class PISCOFINSRestController {

    @Autowired
    private PISCOFINSService piscofinsService;

    @GetMapping
    public List<PISCOFINS> listar() {
        return piscofinsService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<PISCOFINS> salvar(@RequestBody PISCOFINS piscofins) {
        PISCOFINS novoPISCOFINS = piscofinsService.salvar(piscofins);
        return ResponseEntity.ok(novoPISCOFINS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (piscofinsService.buscarPorId(id).isPresent()) {
            piscofinsService.excluir(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}