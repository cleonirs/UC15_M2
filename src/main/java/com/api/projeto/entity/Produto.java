package com.api.projeto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo; // Código interno do produto
    private String descricao;
    private String codBarras;

    // Relacionamentos com as tabelas mestras (referência aos IDs)
    
    // Categoria
    @ManyToOne 
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
    
    // Origem (Página 09)
    @ManyToOne 
    @JoinColumn(name = "origem_id", nullable = false)
    private Origem origem;
    
    // NCM (Página 08)
    @ManyToOne 
    @JoinColumn(name = "ncm_id", nullable = false)
    private NCM ncm;
    
    // CEST (Página 05) - Pode ser opcional em alguns produtos
    @ManyToOne
    @JoinColumn(name = "cest_id")
    private CEST cest;

    // CST (Página 07)
    @ManyToOne 
    @JoinColumn(name = "cst_entrada_id", nullable = false)
    private CST cstEntrada;

    @ManyToOne 
    @JoinColumn(name = "cst_saida_id", nullable = false)
    private CST cstSaida;
    
    // ICMS (Página 03) - Usando ICMS (TUDO MAIÚSCULO) para compatibilidade
    @ManyToOne 
    @JoinColumn(name = "icms_entrada_id", nullable = false)
    private ICMS icmsEntrada;
    
    @ManyToOne 
    @JoinColumn(name = "icms_saida_id", nullable = false)
    private ICMS icmsSaida;

    // PISCOFINS (Página 04) - Usando PISCOFINS (TUDO MAIÚSCULO) para compatibilidade
    @ManyToOne 
    @JoinColumn(name = "pis_cofins_id", nullable = false)
    private PISCOFINS pisCofins;

    // FCP (Página 02) - Usando FCP (TUDO MAIÚSCULO) para compatibilidade
    @ManyToOne 
    @JoinColumn(name = "fcp_id", nullable = false)
    private FCP fcp;


    // Construtores
    public Produto() {}
    
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public NCM getNcm() {
        return ncm;
    }

    public void setNcm(NCM ncm) {
        this.ncm = ncm;
    }

    public CEST getCest() {
        return cest;
    }

    public void setCest(CEST cest) {
        this.cest = cest;
    }

    public CST getCstEntrada() {
        return cstEntrada;
    }

    public void setCstEntrada(CST cstEntrada) {
        this.cstEntrada = cstEntrada;
    }

    public CST getCstSaida() {
        return cstSaida;
    }

    public void setCstSaida(CST cstSaida) {
        this.cstSaida = cstSaida;
    }

    public ICMS getIcmsEntrada() { // ICMS TUDO MAIÚSCULO
        return icmsEntrada;
    }

    public void setIcmsEntrada(ICMS icmsEntrada) { // ICMS TUDO MAIÚSCULO
        this.icmsEntrada = icmsEntrada;
    }

    public ICMS getIcmsSaida() { // ICMS TUDO MAIÚSCULO
        return icmsSaida;
    }

    public void setIcmsSaida(ICMS icmsSaida) { // ICMS TUDO MAIÚSCULO
        this.icmsSaida = icmsSaida;
    }

    public PISCOFINS getPisCofins() { // PISCOFINS TUDO MAIÚSCULO
        return pisCofins;
    }

    public void setPisCofins(PISCOFINS pisCofins) { // PISCOFINS TUDO MAIÚSCULO
        this.pisCofins = pisCofins;
    }

    public FCP getFcp() { // FCP TUDO MAIÚSCULO
        return fcp;
    }

    public void setFcp(FCP fcp) { // FCP TUDO MAIÚSCULO
        this.fcp = fcp;
    }
}