package com.itb.inf2em.eclappse.model.services;

import com.itb.inf2em.eclappse.model.entity.Favorito;
import com.itb.inf2em.eclappse.model.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritoService {



    private final FavoritoRepository favoritoRepository;

    public FavoritoService(FavoritoRepository favoritoRepository) {
        this.favoritoRepository = favoritoRepository;
    }

    public List<Favorito> findAll() { return favoritoRepository.findAll(); }

    public Optional<Favorito> findById(Long id) { return favoritoRepository.findById(id); }

    @Transactional
    public Favorito save(Favorito favorito) { return favoritoRepository.save(favorito); }

    @Transactional
    public void deleteById(Long id) { favoritoRepository.deleteById(id); }
}