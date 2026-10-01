package com.itb.inf2em.eclappse.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itb.inf2em.eclappse.model.entity.Auditoria;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> { List<Auditoria> findByUsuarioIdOrderByDataAcaoDesc(Long usuarioId); }
