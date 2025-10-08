package com.api.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaController {
    
    @GetMapping("/inicio.html")
    public String exibirPaginaInicial() {
        return "inicio"; 
    }

    @GetMapping("/pagina01.html")
    public String exibirPagina01() {
        return "pagina01"; 
    }
    
    @GetMapping("/pagina02.html")
    public String exibirCadastroFCP() {
        return "pagina02"; 
    }
    
    @GetMapping("/pagina03.html")
    public String exibirCadastroICMS() {
        return "pagina03"; 
    }

    @GetMapping("/pagina04.html")
    public String exibirCadastroPISCOFINS() {
        return "pagina04"; 
    }
    
    @GetMapping("/pagina05.html")
    public String exibirCadastroCategoria() {
        return "pagina05"; 
    } 
    
    @GetMapping("/pagina06.html")
    public String exibirCadastroCEST() {
        return "pagina06"; 
    }    
 
    @GetMapping("/pagina07.html")
    public String exibirCadastroCST() {
        return "pagina07"; 
    }

    @GetMapping("/pagina08.html")
    public String exibirCadastroNCM() {
        return "pagina08"; 
    }

    @GetMapping("/pagina09.html")
    public String exibirCadastroOrigem() {
        return "pagina09"; 
    }

    @GetMapping("/pagina10.html")
    public String exibirCadastroProduto() {
        return "pagina10"; 
    }

    @GetMapping("/pagina11.html")
    public String exibirRelatorioProduto() {
        return "pagina11"; 
    }
}