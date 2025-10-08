package com.api.projeto.repository;

import com.api.projeto.entity.NCM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NCMRepository extends JpaRepository<NCM, Long> {
}