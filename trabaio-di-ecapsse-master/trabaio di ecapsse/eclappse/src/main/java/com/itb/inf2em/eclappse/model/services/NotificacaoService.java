package com.itb.inf2em.eclappse.model.services;
import com.itb.inf2em.eclappse.model.entity.Notificacao;
import com.itb.inf2em.eclappse.model.repository.NotificacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class NotificacaoService {
 private final NotificacaoRepository notificacaoRepository;
 public NotificacaoService(NotificacaoRepository notificacaoRepository){this.notificacaoRepository=notificacaoRepository;}
 public List<Notificacao> findAll(){return notificacaoRepository.findAll();}
 public Optional<Notificacao> findById(Long id){return notificacaoRepository.findById(id);}
 public List<Notificacao> findByUsuario(Long id){return notificacaoRepository.findByUsuarioDestinoIdOrderByDataEnvioDesc(id);} public List<Notificacao> findNaoLidas(Long id){return notificacaoRepository.findByUsuarioDestinoIdAndLidaFalseOrderByDataEnvioDesc(id);}
 @Transactional public Notificacao save(Notificacao obj){return notificacaoRepository.save(obj);}
 @Transactional public void deleteById(Long id){notificacaoRepository.deleteById(id);}
}
