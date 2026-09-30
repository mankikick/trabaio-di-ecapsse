package com.itb.inf2em.eclappse.model.services;

import com.itb.inf2em.eclappse.model.entity.Penalidade;
import com.itb.inf2em.eclappse.model.repository.PenalidadeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// PenalidadeService.java
@Service
public class PenalidadeService {

    private final PenalidadeRepository penalidadeRepository;

    public PenalidadeService(PenalidadeRepository penalidadeRepository) {
        this.penalidadeRepository = penalidadeRepository;
    }

    public List<Penalidade> findAll() { return penalidadeRepository.findAll(); }

    public Optional<Penalidade> findById(Long id) { return penalidadeRepository.findById(id); }

    @Transactional
    public Penalidade save(Penalidade penalidade) { return penalidadeRepository.save(penalidade); }

    @Transactional
    public void deleteById(Long id) { penalidadeRepository.deleteById(id); }
}