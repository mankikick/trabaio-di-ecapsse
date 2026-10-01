package com.itb.inf2em.eclappse.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.itb.inf2em.eclappse.model.entity.Favorito;
import com.itb.inf2em.eclappse.model.entity.FavoritoId;
import com.itb.inf2em.eclappse.model.services.FavoritoService;

@RestController
@RequestMapping("/api/v1/favoritos")
public class FavoritoController {
    private final FavoritoService service;

    public FavoritoController(FavoritoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Favorito> findAll() {
        return service.findAll();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Favorito> byUsuario(@PathVariable Long usuarioId) {
        return service.findByUsuario(usuarioId);
    }

    @GetMapping("/{usuarioId}/{casoId}")
    public ResponseEntity<Favorito> find(@PathVariable Long usuarioId, @PathVariable Long casoId) {
        return service.findById(new FavoritoId(usuarioId, casoId)).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Favorito> save(@RequestBody Favorito obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(obj));
    }

    @DeleteMapping("/{usuarioId}/{casoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long usuarioId, @PathVariable Long casoId) {
        service.deleteById(new FavoritoId(usuarioId, casoId));
    }
}
