package com.itb.inf2em.eclappse.model.services;

import com.itb.inf2em.eclappse.model.entity.Usuario;
import com.itb.inf2em.eclappse.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // 1. Listar todos
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // 2. Buscar por ID
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id " + id));
    }

    // 3. Salvar novo usuário
    @Transactional
    public Usuario save(Usuario usuario) {
        if (usuario.getStatusConta() == null) {
            usuario.setStatusConta("ATIVO");
        }
        return usuarioRepository.save(usuario);
    }

    // 4. Atualizar usuário existente
    @Transactional
    public Usuario update(Long id, Usuario usuario) {
        Usuario usuarioExistente = findById(id);

        if (usuario.getNome() != null) usuarioExistente.setNome(usuario.getNome());
        if (usuario.getEmail() != null) usuarioExistente.setEmail(usuario.getEmail());
        if (usuario.getUsername() != null) usuarioExistente.setUsername(usuario.getUsername());
        if (usuario.getPassword() != null) usuarioExistente.setPassword(usuario.getPassword());
        if (usuario.getCpf() != null) usuarioExistente.setCpf(usuario.getCpf());
        if (usuario.getTelefone() != null) usuarioExistente.setTelefone(usuario.getTelefone());
        if (usuario.getFoto() != null) usuarioExistente.setFoto(usuario.getFoto());
        if (usuario.getPerfil() != null) usuarioExistente.setPerfil(usuario.getPerfil());
        if (usuario.getStatusConta() != null) usuarioExistente.setStatusConta(usuario.getStatusConta());
        if (usuario.getTokenConfirmacao() != null) usuarioExistente.setTokenConfirmacao(usuario.getTokenConfirmacao());
        if (usuario.getTokenRecuperacao() != null) usuarioExistente.setTokenRecuperacao(usuario.getTokenRecuperacao());
        if (usuario.getExpiracaoToken() != null) usuarioExistente.setExpiracaoToken(usuario.getExpiracaoToken());

        return usuarioRepository.save(usuarioExistente);
    }

    // 5. Excluir por ID
    @Transactional
    public void delete(Long id) {
        Usuario usuarioExistente = findById(id);
        usuarioRepository.delete(usuarioExistente);
    }
}