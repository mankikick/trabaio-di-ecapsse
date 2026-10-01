package com.itb.inf2em.eclappse.model.services;
import com.itb.inf2em.eclappse.model.entity.Auditoria;
import com.itb.inf2em.eclappse.model.repository.AuditoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class AuditoriaService {
 private final AuditoriaRepository auditoriaRepository;
 public AuditoriaService(AuditoriaRepository auditoriaRepository){this.auditoriaRepository=auditoriaRepository;}
 public List<Auditoria> findAll(){return auditoriaRepository.findAll();}
 public Optional<Auditoria> findById(Long id){return auditoriaRepository.findById(id);}
 public List<Auditoria> findByUsuario(Long id){return auditoriaRepository.findByUsuarioIdOrderByDataAcaoDesc(id);}
 @Transactional public Auditoria save(Auditoria obj){return auditoriaRepository.save(obj);}
 @Transactional public void deleteById(Long id){auditoriaRepository.deleteById(id);}
}
