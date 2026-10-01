package com.itb.inf2em.eclappse.controller;
import com.itb.inf2em.eclappse.model.entity.HistoricoCaso;
import com.itb.inf2em.eclappse.model.services.HistoricoCasoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/v1/historico-casos")
public class HistoricoCasoController {
 private final HistoricoCasoService service; public HistoricoCasoController(HistoricoCasoService service){this.service=service;}
 @GetMapping public List<HistoricoCaso> findAll(){return service.findAll();}
 @GetMapping("/{id}") public ResponseEntity<HistoricoCaso> findById(@PathVariable Long id){return service.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());}
 @GetMapping("/caso/{casoId}") public List<HistoricoCaso> byCaso(@PathVariable Long casoId){return service.findByCaso(casoId);}
 @PostMapping public ResponseEntity<HistoricoCaso> save(@RequestBody HistoricoCaso obj){return ResponseEntity.status(HttpStatus.CREATED).body(service.save(obj));}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.deleteById(id);}
}
