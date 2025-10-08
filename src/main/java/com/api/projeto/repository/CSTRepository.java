package com.api.projeto.repository;

import com.api.projeto.entity.CST;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CSTRepository extends JpaRepository<CST, Long> {
}