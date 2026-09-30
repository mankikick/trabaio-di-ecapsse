package com.itb.inf2em.eclappse.model.repository;

import com.itb.inf2em.eclappse.model.entity.HistoricoCaso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HistoricoCasoRepository extends JpaRepository<HistoricoCaso, Long> {
    Optional<HistoricoCaso> findById(Long id);

    List<HistoricoCaso> findAll();

    void deleteById(Long id);

    HistoricoCaso save(HistoricoCaso historicoCaso);
}
