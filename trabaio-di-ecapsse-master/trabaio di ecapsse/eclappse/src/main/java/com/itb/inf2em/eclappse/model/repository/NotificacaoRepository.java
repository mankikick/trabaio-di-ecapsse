package com.itb.inf2em.eclappse.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itb.inf2em.eclappse.model.entity.Notificacao;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> { List<Notificacao> findByUsuarioDestinoIdOrderByDataEnvioDesc(Long usuarioId); List<Notificacao> findByUsuarioDestinoIdAndLidaFalseOrderByDataEnvioDesc(Long usuarioId); }
