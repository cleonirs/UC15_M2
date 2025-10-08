package com.api.projeto.repository;

import com.api.projeto.entity.Origem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrigemRepository extends JpaRepository<Origem, Long> {
}