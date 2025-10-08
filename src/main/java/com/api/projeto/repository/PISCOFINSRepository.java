package com.api.projeto.repository;

import com.api.projeto.entity.PISCOFINS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PISCOFINSRepository extends JpaRepository<PISCOFINS, Long> {
}