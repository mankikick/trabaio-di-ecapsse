package com.itb.inf2em.eclappse.model.repository;


import com.itb.inf2em.eclappse.model.entity.Penalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenalidadeRepository extends JpaRepository<Penalidade, Long> {
}
