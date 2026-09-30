package com.itb.inf2em.eclappse.model.repository;


import com.itb.inf2em.eclappse.model.entity.Avistamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvistamentoRepository extends JpaRepository<Avistamento, Long> {
    Optional<Avistamento> findById(Integer id);
}
