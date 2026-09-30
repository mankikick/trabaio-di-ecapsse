package com.itb.inf2em.eclappse.model.services;

import com.itb.inf2em.eclappse.model.entity.ModeracaoConteudo;
import com.itb.inf2em.eclappse.model.repository.ModeracaoConteudoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// ModeracaoConteudoService.java
@Service
public class ModeracaoConteudoService {

    private final ModeracaoConteudoRepository moderacaoConteudoRepository;

    public ModeracaoConteudoService(ModeracaoConteudoRepository moderacaoConteudoRepository) {
        this.moderacaoConteudoRepository = moderacaoConteudoRepository;
    }

    public List<ModeracaoConteudo> findAll() { return moderacaoConteudoRepository.findAll(); }

    public Optional<ModeracaoConteudo> findById(Long id) { return moderacaoConteudoRepository.findById(id); }

    @Transactional
    public ModeracaoConteudo save(ModeracaoConteudo moderacaoConteudo) { return moderacaoConteudoRepository.save(moderacaoConteudo); }

    @Transactional
    public void deleteById(Long id) { moderacaoConteudoRepository.deleteById(id); }
}