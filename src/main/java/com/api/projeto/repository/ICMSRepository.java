package com.api.projeto.repository;

import com.api.projeto.entity.ICMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICMSRepository extends JpaRepository<ICMS, Long> {
    // Métodos CRUD básicos herdados do JpaRepository
}