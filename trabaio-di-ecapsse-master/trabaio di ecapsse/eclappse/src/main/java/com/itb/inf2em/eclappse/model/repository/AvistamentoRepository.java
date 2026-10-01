package com.itb.inf2em.eclappse.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itb.inf2em.eclappse.model.entity.Avistamento;

public interface AvistamentoRepository extends JpaRepository<Avistamento, Long> { List<Avistamento> findByCasoId(Long casoId); List<Avistamento> findByStatusAvistamento(String statusAvistamento); }
