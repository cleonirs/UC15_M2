package com.api.projeto.repository;

import com.api.projeto.entity.CEST;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CESTRepository extends JpaRepository<CEST, Long> {
}