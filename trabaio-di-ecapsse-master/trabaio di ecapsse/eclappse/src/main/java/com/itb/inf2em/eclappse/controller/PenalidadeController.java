package com.itb.inf2em.eclappse.controller;

import com.itb.inf2em.eclappse.model.entity.Penalidade;
import com.itb.inf2em.eclappse.model.services.PenalidadeService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/penalidades")
public class PenalidadeController {
    private final PenalidadeService service;

    public PenalidadeController(PenalidadeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Penalidade> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Penalidade> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Penalidade> byUsuario(@PathVariable Long usuarioId) {
        return service.findByUsuario(usuarioId);
    }

    @PostMapping
    public ResponseEntity<Penalidade> save(@RequestBody Penalidade obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(obj));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
