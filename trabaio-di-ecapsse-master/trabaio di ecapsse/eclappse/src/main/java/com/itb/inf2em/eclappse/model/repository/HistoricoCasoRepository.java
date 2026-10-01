package com.itb.inf2em.eclappse.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itb.inf2em.eclappse.model.entity.HistoricoCaso;
public interface HistoricoCasoRepository extends JpaRepository<HistoricoCaso, Long> { List<HistoricoCaso> findByCasoIdOrderByDataRegistroDesc(Long casoId); }
