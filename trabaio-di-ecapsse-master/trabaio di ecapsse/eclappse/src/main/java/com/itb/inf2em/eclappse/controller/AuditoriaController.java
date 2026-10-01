package com.itb.inf2em.eclappse.controller;

import com.itb.inf2em.eclappse.model.entity.Auditoria;
import com.itb.inf2em.eclappse.model.services.AuditoriaService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auditoria")
public class AuditoriaController {
    private final AuditoriaService service;

    public AuditoriaController(AuditoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Auditoria> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auditoria> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Auditoria> byUsuario(@PathVariable Long usuarioId) {
        return service.findByUsuario(usuarioId);
    }

    @PostMapping
    public ResponseEntity<Auditoria> save(@RequestBody Auditoria obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(obj));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
