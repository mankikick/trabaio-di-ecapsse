package com.itb.inf2em.eclappse.model.services;
import com.itb.inf2em.eclappse.model.entity.Usuario;
import com.itb.inf2em.eclappse.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class UsuarioService {
 private final UsuarioRepository usuarioRepository;
 public UsuarioService(UsuarioRepository usuarioRepository){this.usuarioRepository=usuarioRepository;}
 public List<Usuario> findAll(){return usuarioRepository.findAll();}
 public Usuario findById(Long id){return usuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Usuário não encontrado com o id "+id));}
 @Transactional public Usuario save(Usuario usuario){if(usuario.getStatusConta()==null)usuario.setStatusConta("ATIVO");return usuarioRepository.save(usuario);}
 @Transactional public Usuario update(Long id,Usuario usuario){Usuario existente=findById(id);if(usuario.getNome()!=null)existente.setNome(usuario.getNome());if(usuario.getEmail()!=null)existente.setEmail(usuario.getEmail());if(usuario.getUsername()!=null)existente.setUsername(usuario.getUsername());if(usuario.getPassword()!=null)existente.setPassword(usuario.getPassword());if(usuario.getCpf()!=null)existente.setCpf(usuario.getCpf());if(usuario.getTelefone()!=null)existente.setTelefone(usuario.getTelefone());if(usuario.getFoto()!=null)existente.setFoto(usuario.getFoto());if(usuario.getPerfil()!=null)existente.setPerfil(usuario.getPerfil());if(usuario.getStatusConta()!=null)existente.setStatusConta(usuario.getStatusConta());if(usuario.getTokenConfirmacao()!=null)existente.setTokenConfirmacao(usuario.getTokenConfirmacao());if(usuario.getTokenRecuperacao()!=null)existente.setTokenRecuperacao(usuario.getTokenRecuperacao());if(usuario.getExpiracaoToken()!=null)existente.setExpiracaoToken(usuario.getExpiracaoToken());return usuarioRepository.save(existente);}
 @Transactional public void delete(Long id){usuarioRepository.delete(findById(id));}
}
