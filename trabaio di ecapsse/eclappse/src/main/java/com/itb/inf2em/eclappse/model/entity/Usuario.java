package com.itb.inf2em.eclappse.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false, unique = true)
    private String username;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(columnDefinition = "CHAR(11)", unique = true)
    private String cpf;

    @Column(length = 20)
    private String telefone;

    @Column(length = 500)
    private String foto;

    @Column(nullable = false, length = 30)
    private String perfil;

    @Column(name = "status_conta", nullable = false, length = 20)
    private String statusConta = "ATIVO";

    @Column(name = "token_confirmacao", length = 255)
    private String tokenConfirmacao;

    @Column(name = "token_recuperacao", length = 255)
    private String tokenRecuperacao;

    @Column(name = "expiracao_token")
    private LocalDateTime expiracaoToken;

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @PrePersist
    void prePersist() {
        if (dataCadastro == null) dataCadastro = LocalDateTime.now();
        if (statusConta == null) statusConta = "ATIVO";
    }

    @PreUpdate
    void preUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }

    public String getPerfil() { return perfil; }
    public void setPerfil(String perfil) { this.perfil = perfil; }

    public String getStatusConta() { return statusConta; }
    public void setStatusConta(String statusConta) { this.statusConta = statusConta; }

    public String getTokenConfirmacao() { return tokenConfirmacao; }
    public void setTokenConfirmacao(String tokenConfirmacao) { this.tokenConfirmacao = tokenConfirmacao; }

    public String getTokenRecuperacao() { return tokenRecuperacao; }
    public void setTokenRecuperacao(String tokenRecuperacao) { this.tokenRecuperacao = tokenRecuperacao; }

    public LocalDateTime getExpiracaoToken() { return expiracaoToken; }
    public void setExpiracaoToken(LocalDateTime expiracaoToken) { this.expiracaoToken = expiracaoToken; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public LocalDateTime getDataAtualizacao() { return dataAtualizacao; }
    public void setDataAtualizacao(LocalDateTime dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }
}