package com.itb.inf2em.eclappse.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itb.inf2em.eclappse.model.entity.Favorito;
import com.itb.inf2em.eclappse.model.entity.FavoritoId;


public interface FavoritoRepository extends JpaRepository<Favorito, FavoritoId> {
    List<Favorito> findByIdUsuarioId(Long usuarioId);
}