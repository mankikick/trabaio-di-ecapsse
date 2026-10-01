package com.itb.inf2em.eclappse.controller;
import com.itb.inf2em.eclappse.model.entity.Usuario;
import com.itb.inf2em.eclappse.model.services.UsuarioService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/v1/usuarios")
public class UsuarioController {
 private final UsuarioService service; public UsuarioController(UsuarioService service){this.service=service;}
 @GetMapping public List<Usuario> findAll(){return service.findAll();}
 @GetMapping("/{id}") public Usuario findById(@PathVariable Long id){return service.findById(id);}
 @PostMapping public ResponseEntity<Usuario> salvar(@RequestBody Usuario u){return ResponseEntity.status(HttpStatus.CREATED).body(service.save(u));}
 @PutMapping("/{id}") public Usuario atualizar(@PathVariable Long id,@RequestBody Usuario u){return service.update(id,u);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void deletar(@PathVariable Long id){service.delete(id);}
}
