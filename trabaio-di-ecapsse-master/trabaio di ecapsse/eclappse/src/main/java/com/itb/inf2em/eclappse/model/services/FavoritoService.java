package com.itb.inf2em.eclappse.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itb.inf2em.eclappse.model.entity.Favorito;
import com.itb.inf2em.eclappse.model.entity.FavoritoId;
import com.itb.inf2em.eclappse.model.repository.FavoritoRepository;

@Service
public class FavoritoService {
    private final FavoritoRepository favoritoRepository;

    public FavoritoService(FavoritoRepository favoritoRepository) {
        this.favoritoRepository = favoritoRepository;
    }

    public List<Favorito> findAll() {
        return favoritoRepository.findAll();
    }

    public List<Favorito> findByUsuario(Long id) {
        return favoritoRepository.findByIdUsuarioId(id);
    }

    public Optional<Favorito> findById(FavoritoId id) {
        return favoritoRepository.findById(id);
    }

    @Transactional
    public Favorito save(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    @Transactional
    public void deleteById(FavoritoId id) {
        favoritoRepository.deleteById(id);
    }
}
