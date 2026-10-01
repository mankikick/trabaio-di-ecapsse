package com.itb.inf2em.eclappse.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itb.inf2em.eclappse.model.entity.Penalidade;

public interface PenalidadeRepository extends JpaRepository<Penalidade, Long> { List<Penalidade> findByUsuarioInfratorId(Long usuarioId); }
