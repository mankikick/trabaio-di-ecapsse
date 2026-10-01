package com.itb.inf2em.eclappse.model.services;
import com.itb.inf2em.eclappse.model.entity.Avistamento;
import com.itb.inf2em.eclappse.model.repository.AvistamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class AvistamentoService {
 private final AvistamentoRepository avistamentoRepository;
 public AvistamentoService(AvistamentoRepository avistamentoRepository){this.avistamentoRepository=avistamentoRepository;}
 public List<Avistamento> findAll(){return avistamentoRepository.findAll();}
 public Optional<Avistamento> findById(Long id){return avistamentoRepository.findById(id);}
 public List<Avistamento> findByCaso(Long id){return avistamentoRepository.findByCasoId(id);} public List<Avistamento> findByStatus(String status){return avistamentoRepository.findByStatusAvistamento(status);}
 @Transactional public Avistamento save(Avistamento obj){return avistamentoRepository.save(obj);}
 @Transactional public void deleteById(Long id){avistamentoRepository.deleteById(id);}
}
