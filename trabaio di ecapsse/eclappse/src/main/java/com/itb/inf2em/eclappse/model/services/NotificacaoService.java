package com.itb.inf2em.eclappse.model.services;

import com.itb.inf2em.eclappse.model.entity.Notificacao;
import com.itb.inf2em.eclappse.model.repository.NotificacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// NotificacaoConteudoService.java
@Service
public class NotificacaoService {

    private NotificacaoRepository notificacaoRepository;

    public void NotificacaoService(NotificacaoRepository notificacaoRepository) {
        this.notificacaoRepository = notificacaoRepository;
    }

    public List<Notificacao> findAll() { return notificacaoRepository.findAll(); }

    public Optional<Notificacao> findById(Long id) { return notificacaoRepository.findById(id); }

    @Transactional
    public Notificacao save(Notificacao notificacao) { return notificacaoRepository.save(notificacao); }

    @Transactional
    public void deleteById(Long id) { notificacaoRepository.deleteById(id); }
}