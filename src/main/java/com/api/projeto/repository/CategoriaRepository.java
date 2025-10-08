package com.api.projeto.repository;

import com.api.projeto.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// <Entity, Tipo da Chave Primária>
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}