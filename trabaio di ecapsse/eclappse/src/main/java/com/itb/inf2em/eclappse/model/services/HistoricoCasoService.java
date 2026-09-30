package com.itb.inf2em.eclappse.model.services;

import com.itb.inf2em.eclappse.model.entity.HistoricoCaso;
import com.itb.inf2em.eclappse.model.repository.HistoricoCasoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

// HistoricoCasoService.java
@Service
public class HistoricoCasoService {

    private final HistoricoCasoRepository historicoCasoRepository;

    public HistoricoCasoService(HistoricoCasoRepository historicoCasoRepository) {
        this.historicoCasoRepository = historicoCasoRepository;
    }

    public List<HistoricoCaso> findAll() { return historicoCasoRepository.findAll(); }

    public Optional<HistoricoCaso> findById(Long id) { return historicoCasoRepository.findById(id); }

    @Transactional
    public HistoricoCaso save(HistoricoCaso historicoCaso) { return historicoCasoRepository.save(historicoCaso); }

    @Transactional
    public void deleteById(Long id) { historicoCasoRepository.deleteById(id); }
}