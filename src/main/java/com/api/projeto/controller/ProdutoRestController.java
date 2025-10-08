package com.api.projeto.controller;

import com.api.projeto.entity.Produto;
import com.api.projeto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/produto") // Endpoint base
public class ProdutoRestController {

    @Autowired
    private ProdutoService produtoService;

    // NOVO: Método para buscar produto por ID (GET /api/produto/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        // Usa o serviço para tentar encontrar o produto
        return produtoService.buscarPorId(id)
                // Se o Optional tiver o produto, retorna 200 OK
                .map(ResponseEntity::ok)
                // Se o Optional estiver vazio (produto não encontrado), retorna 404 Not Found
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        // O serviço cuidará de anexar (attach) as entidades mestras antes de salvar
        Produto novoProduto = produtoService.salvar(produto);
        return ResponseEntity.ok(novoProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (produtoService.buscarPorId(id).isPresent()) {
            produtoService.excluir(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}