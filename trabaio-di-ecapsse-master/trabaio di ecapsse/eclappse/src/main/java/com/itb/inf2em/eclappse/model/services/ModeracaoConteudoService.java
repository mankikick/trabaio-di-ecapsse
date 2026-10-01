package com.itb.inf2em.eclappse.model.services;
import com.itb.inf2em.eclappse.model.entity.ModeracaoConteudo;
import com.itb.inf2em.eclappse.model.repository.ModeracaoConteudoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class ModeracaoConteudoService {
 private final ModeracaoConteudoRepository moderacaoConteudoRepository;
 public ModeracaoConteudoService(ModeracaoConteudoRepository moderacaoConteudoRepository){this.moderacaoConteudoRepository=moderacaoConteudoRepository;}
 public List<ModeracaoConteudo> findAll(){return moderacaoConteudoRepository.findAll();}
 public Optional<ModeracaoConteudo> findById(Long id){return moderacaoConteudoRepository.findById(id);}
 public List<ModeracaoConteudo> findByStatus(String status){return moderacaoConteudoRepository.findByStatusConteudo(status);}
 @Transactional public ModeracaoConteudo save(ModeracaoConteudo obj){return moderacaoConteudoRepository.save(obj);}
 @Transactional public void deleteById(Long id){moderacaoConteudoRepository.deleteById(id);}
}
