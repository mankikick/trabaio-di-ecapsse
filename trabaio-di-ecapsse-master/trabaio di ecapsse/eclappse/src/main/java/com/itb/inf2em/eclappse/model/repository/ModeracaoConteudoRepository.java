package com.itb.inf2em.eclappse.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itb.inf2em.eclappse.model.entity.ModeracaoConteudo;
public interface ModeracaoConteudoRepository extends JpaRepository<ModeracaoConteudo, Long> { List<ModeracaoConteudo> findByStatusConteudo(String statusConteudo); }
