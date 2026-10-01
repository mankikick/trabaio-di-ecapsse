package com.itb.inf2em.eclappse.controller;
import com.itb.inf2em.eclappse.model.entity.ModeracaoConteudo;
import com.itb.inf2em.eclappse.model.services.ModeracaoConteudoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/v1/moderacao-conteudo")
public class ModeracaoConteudoController {
 private final ModeracaoConteudoService service; public ModeracaoConteudoController(ModeracaoConteudoService service){this.service=service;}
 @GetMapping public List<ModeracaoConteudo> findAll(){return service.findAll();}
 @GetMapping("/{id}") public ResponseEntity<ModeracaoConteudo> findById(@PathVariable Long id){return service.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());}
 @GetMapping("/status/{status}") public List<ModeracaoConteudo> byStatus(@PathVariable String status){return service.findByStatus(status);}
 @PostMapping public ResponseEntity<ModeracaoConteudo> save(@RequestBody ModeracaoConteudo obj){return ResponseEntity.status(HttpStatus.CREATED).body(service.save(obj));}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.deleteById(id);}
}
