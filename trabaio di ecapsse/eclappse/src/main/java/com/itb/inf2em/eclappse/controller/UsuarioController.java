package com.itb.inf2em.eclappse.controller;

import com.itb.inf2em.eclappse.model.entity.Usuario;
import com.itb.inf2em.eclappse.model.services.CasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private CasoService casoService;

    private List<Usuario> usuarios = new ArrayList<Usuario>();

    // Inicializa o usuário padrão apenas uma vez quando o Controller é criado
    public UsuarioController() {
        Usuario p1 = new Usuario();
        p1.setNome("Caso 67");
        p1.setTokenConfirmacao("123456");
        p1.setStatusConta(true);

        usuarios.add(p1);
    }

    // Rota GET (para buscar/listar)
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarios);
    }

    // Rota POST (retorna HTTP 201 Created)
    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        usuarios.add(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
}