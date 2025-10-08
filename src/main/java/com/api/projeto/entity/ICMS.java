package com.api.projeto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "icms")
public class ICMS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campos Fiscais Corrigidos
    private Double aliquota;
    private Double reducao;     // Novo campo para percentual de redução
    private String validoAte;   // Novo campo para data de validade (formato String)

    // Construtores
    public ICMS() {}
    
    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Campo ALIQUOTA
    public Double getAliquota() {
        return aliquota;
    }

    public void setAliquota(Double aliquota) {
        this.aliquota = aliquota;
    }

    // Campo REDUCAO
    public Double getReducao() {
        return reducao;
    }

    public void setReducao(Double reducao) {
        this.reducao = reducao;
    }

    // Campo VALIDO ATE
    public String getValidoAte() {
        return validoAte;
    }

    public void setValidoAte(String validoAte) {
        this.validoAte = validoAte;
    }
}