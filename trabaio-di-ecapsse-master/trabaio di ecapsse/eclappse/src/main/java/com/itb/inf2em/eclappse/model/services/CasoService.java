package com.itb.inf2em.eclappse.model.services;
import com.itb.inf2em.eclappse.model.entity.Caso;
import com.itb.inf2em.eclappse.model.repository.CasoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class CasoService {
 private final CasoRepository casoRepository;
 public CasoService(CasoRepository casoRepository){this.casoRepository=casoRepository;}
 public List<Caso> findAll(){return casoRepository.findAll();}
 public Optional<Caso> findById(Long id){return casoRepository.findById(id);}
 public List<Caso> findByStatus(String status){return casoRepository.findByStatusCaso(status);}
 @Transactional public Caso save(Caso obj){return casoRepository.save(obj);}
 @Transactional public void deleteById(Long id){casoRepository.deleteById(id);}
}
