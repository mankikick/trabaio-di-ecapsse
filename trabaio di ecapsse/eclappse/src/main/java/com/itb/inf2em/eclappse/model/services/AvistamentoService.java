package com.itb.inf2em.eclappse.model.services;

import com.itb.inf2em.eclappse.model.entity.Avistamento;
import com.itb.inf2em.eclappse.model.repository.AvistamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AvistamentoService {



    private final AvistamentoRepository avistamentoRepository;

    public AvistamentoService(AvistamentoRepository avistamentoRepository) {
        this.avistamentoRepository = avistamentoRepository;
    }

    public List<Avistamento> findAll() { return avistamentoRepository.findAll(); }

    public Optional<Avistamento> findById(Integer id) { return avistamentoRepository.findById(id); }

    @Transactional
    public Avistamento save(Avistamento avistamento) { return avistamentoRepository.save(avistamento); }

    @Transactional
    public void deleteById(Integer id) { avistamentoRepository.deleteById(Long.valueOf(id)); }
}