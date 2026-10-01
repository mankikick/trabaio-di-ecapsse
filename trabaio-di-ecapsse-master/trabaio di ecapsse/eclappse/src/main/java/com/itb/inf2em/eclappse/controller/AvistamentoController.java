package com.itb.inf2em.eclappse.controller;
import com.itb.inf2em.eclappse.model.entity.Avistamento;
import com.itb.inf2em.eclappse.model.services.AvistamentoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/v1/avistamentos")
public class AvistamentoController {
 private final AvistamentoService service; public AvistamentoController(AvistamentoService service){this.service=service;}
 @GetMapping public List<Avistamento> findAll(){return service.findAll();}
 @GetMapping("/{id}") public ResponseEntity<Avistamento> findById(@PathVariable Long id){return service.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());}
 @GetMapping("/caso/{casoId}") public List<Avistamento> byCaso(@PathVariable Long casoId){return service.findByCaso(casoId);} @GetMapping("/status/{status}") public List<Avistamento> byStatus(@PathVariable String status){return service.findByStatus(status);}
 @PostMapping public ResponseEntity<Avistamento> save(@RequestBody Avistamento obj){return ResponseEntity.status(HttpStatus.CREATED).body(service.save(obj));}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.deleteById(id);}
}
