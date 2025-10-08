package com.api.projeto.repository;

import com.api.projeto.entity.FCP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FCPRepository extends JpaRepository<FCP, Long> {

}
