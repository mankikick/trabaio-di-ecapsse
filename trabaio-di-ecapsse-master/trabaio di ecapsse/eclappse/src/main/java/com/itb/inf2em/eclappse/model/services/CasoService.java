package com.itb.inf2em.eclappse.model.services;
import com.itb.inf2em.eclappse.model.entity.Caso;
import com.itb.inf2em.eclappse.model.repository.CasoRepository;
import com.itb.inf2em.eclappse.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class CasoService {
 private final CasoRepository casoRepository;
 private final UsuarioRepository usuarioRepository;
 public CasoService(CasoRepository casoRepository, UsuarioRepository usuarioRepository){
  this.casoRepository=casoRepository;
  this.usuarioRepository=usuarioRepository;
 }
 public List<Caso> findAll(){return casoRepository.findAll();}
 public Optional<Caso> findById(Long id){return casoRepository.findById(id);}
 public List<Caso> findByStatus(String status){return casoRepository.findByStatusCaso(status);}
 @Transactional public Caso save(Caso obj){return casoRepository.save(obj);}
 @Transactional public Optional<Caso> update(Long id, Caso dados){
  return casoRepository.findById(id).map(existente -> {
   if (dados.getNomeDesaparecido() != null) existente.setNomeDesaparecido(dados.getNomeDesaparecido());
   existente.setDataNascimento(dados.getDataNascimento());
   if (dados.getDataDesaparecimento() != null) existente.setDataDesaparecimento(dados.getDataDesaparecimento());
   if (dados.getLocalDesaparecimento() != null) existente.setLocalDesaparecimento(dados.getLocalDesaparecimento());
   existente.setCaracteristicasFisicas(dados.getCaracteristicasFisicas());
   existente.setCircunstancias(dados.getCircunstancias());
   if (dados.getStatusCaso() != null) existente.setStatusCaso(dados.getStatusCaso());
   if (dados.getUsuarioResponsavel() != null && dados.getUsuarioResponsavel().getId() != null) {
    usuarioRepository.findById(dados.getUsuarioResponsavel().getId()).ifPresent(existente::setUsuarioResponsavel);
   }
   return casoRepository.save(existente);
  });
 }
 @Transactional public void deleteById(Long id){casoRepository.deleteById(id);}
}
