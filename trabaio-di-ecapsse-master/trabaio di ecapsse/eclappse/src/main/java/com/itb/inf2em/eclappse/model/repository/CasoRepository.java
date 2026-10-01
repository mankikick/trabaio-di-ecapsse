package com.itb.inf2em.eclappse.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itb.inf2em.eclappse.model.entity.Caso;

public interface CasoRepository extends JpaRepository<Caso, Long> { List<Caso> findByStatusCaso(String statusCaso); }
