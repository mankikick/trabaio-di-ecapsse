package com.itb.inf2em.eclappse.model.repository;

import com.itb.inf2em.eclappse.model.entity.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
}
