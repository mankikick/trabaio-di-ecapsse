package com.itb.inf2em.eclappse.controller;
import com.itb.inf2em.eclappse.model.entity.Caso;
import com.itb.inf2em.eclappse.model.services.CasoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/v1/casos")
public class CasoController {
 private final CasoService service; public CasoController(CasoService service){this.service=service;}
 @GetMapping public List<Caso> findAll(){return service.findAll();}
 @GetMapping("/{id}") public ResponseEntity<Caso> findById(@PathVariable Long id){return service.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());}
 @GetMapping("/status/{status}") public List<Caso> byStatus(@PathVariable String status){return service.findByStatus(status);}
 @PostMapping public ResponseEntity<Caso> save(@RequestBody Caso obj){return ResponseEntity.status(HttpStatus.CREATED).body(service.save(obj));}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.deleteById(id);}
}
