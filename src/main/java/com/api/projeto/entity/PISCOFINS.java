package com.api.projeto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "piscofins")
public class PISCOFINS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Código da Situação Tributária (CST) ou outro código de identificação
    private String codigo; 
    
    // Alíquota do PIS
    private Double aliquotaPis; 
    
    // Alíquota da COFINS
    private Double aliquotaCofins; 

    // Construtores
    public PISCOFINS() {}
    
    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getAliquotaPis() {
        return aliquotaPis;
    }

    public void setAliquotaPis(Double aliquotaPis) {
        this.aliquotaPis = aliquotaPis;
    }

    public Double getAliquotaCofins() {
        return aliquotaCofins;
    }

    public void setAliquotaCofins(Double aliquotaCofins) {
        this.aliquotaCofins = aliquotaCofins;
    }
}