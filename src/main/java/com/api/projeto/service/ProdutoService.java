package com.api.projeto.service;

import com.api.projeto.entity.*; 
import com.api.projeto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    // Injeções de Service - AJUSTADAS PARA NOMES EM MAIÚSCULAS
    @Autowired private CategoriaService categoriaService;
    @Autowired private OrigemService origemService;
    @Autowired private NCMService ncmService;
    @Autowired private CESTService cestService;
    @Autowired private CSTService cstService;
    @Autowired private ICMSService icmsService; // <-- ICMSService (TUDO MAIÚSCULO)
    @Autowired private PISCOFINSService pisCofinsService; // <-- PISCOFINSService (TUDO MAIÚSCULO)
    @Autowired private FCPService fcpService; // <-- FCPService (TUDO MAIÚSCULO)


    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto salvar(Produto produto) {
        // Lógica de anexar entidades (attach logic) - Crucial para edição/salvamento
        
        // Categoria
        if (produto.getCategoria() != null && produto.getCategoria().getId() != null) {
            categoriaService.buscarPorId(produto.getCategoria().getId())
                .ifPresent(produto::setCategoria);
        }
        // Origem
        if (produto.getOrigem() != null && produto.getOrigem().getId() != null) {
            origemService.buscarPorId(produto.getOrigem().getId()).ifPresent(produto::setOrigem);
        }
        // NCM
        if (produto.getNcm() != null && produto.getNcm().getId() != null) {
            ncmService.buscarPorId(produto.getNcm().getId()).ifPresent(produto::setNcm);
        }
        // CEST (Opcional)
        if (produto.getCest() != null && produto.getCest().getId() != null) {
            cestService.buscarPorId(produto.getCest().getId()).ifPresent(produto::setCest);
        }
        // CST
        if (produto.getCstEntrada() != null && produto.getCstEntrada().getId() != null) {
            cstService.buscarPorId(produto.getCstEntrada().getId()).ifPresent(produto::setCstEntrada);
        }
        if (produto.getCstSaida() != null && produto.getCstSaida().getId() != null) {
            cstService.buscarPorId(produto.getCstSaida().getId()).ifPresent(produto::setCstSaida);
        }
        // ICMS
        if (produto.getIcmsEntrada() != null && produto.getIcmsEntrada().getId() != null) {
            icmsService.buscarPorId(produto.getIcmsEntrada().getId()).ifPresent(produto::setIcmsEntrada);
        }
        if (produto.getIcmsSaida() != null && produto.getIcmsSaida().getId() != null) {
            icmsService.buscarPorId(produto.getIcmsSaida().getId()).ifPresent(produto::setIcmsSaida);
        }
        // PISCOFINS
        if (produto.getPisCofins() != null && produto.getPisCofins().getId() != null) {
            pisCofinsService.buscarPorId(produto.getPisCofins().getId()).ifPresent(produto::setPisCofins);
        }
        // FCP
        if (produto.getFcp() != null && produto.getFcp().getId() != null) {
            fcpService.buscarPorId(produto.getFcp().getId()).ifPresent(produto::setFcp);
        }
        
        return produtoRepository.save(produto);
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }
}