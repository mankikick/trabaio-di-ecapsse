package com.itb.inf2em.eclappse.controller;

import com.itb.inf2em.eclappse.model.entity.Notificacao;
import com.itb.inf2em.eclappse.model.services.NotificacaoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notificacoes")
public class NotificacaoController {
    private final NotificacaoService service;

    public NotificacaoController(NotificacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Notificacao> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacao> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Notificacao> byUsuario(@PathVariable Long usuarioId) {
        return service.findByUsuario(usuarioId);
    }

    @GetMapping("/usuario/{usuarioId}/nao-lidas")
    public List<Notificacao> naoLidas(@PathVariable Long usuarioId) {
        return service.findNaoLidas(usuarioId);
    }

    @PostMapping
    public ResponseEntity<Notificacao> save(@RequestBody Notificacao obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(obj));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
