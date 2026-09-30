package com.itb.inf2em.eclappse.model.repository;

import com.itb.inf2em.eclappse.model.entity.Caso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasoRepository extends JpaRepository<Caso, Long> {
}
