package com.itb.inf2em.eclappse.model.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itb.inf2em.eclappse.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { Optional<Usuario> findByEmail(String email); Optional<Usuario> findByUsername(String username); boolean existsByEmail(String email); boolean existsByUsername(String username); boolean existsByCpf(String cpf); }
