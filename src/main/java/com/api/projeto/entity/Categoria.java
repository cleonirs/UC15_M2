package com.api.projeto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Marca como tabela do banco de dados
@Data   // Anotação do Lombok (getters, setters, etc.)
@NoArgsConstructor // Construtor sem argumentos
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Chave primária

    @NotBlank(message = "O código é obrigatório")
    private String codigo;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;
}