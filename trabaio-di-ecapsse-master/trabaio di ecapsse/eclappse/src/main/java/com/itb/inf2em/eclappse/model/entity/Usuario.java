package com.itb.inf2em.eclappse.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 100, unique = true)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false, length = 255)
    private String password;
    @JsonIgnore
    @Column(length = 11, unique = true)
    private String cpf;
    @Column(length = 20)
    private String telefone;
    @Column(columnDefinition = "BLOB")
    private byte[] foto;
    @Column(nullable = false, length = 30)
    private String perfil;
    @Column(name = "status_conta", nullable = false, length = 20)
    private String statusConta = "ATIVO";
    @JsonIgnore
    @Column(name = "token_confirmacao", length = 255)
    private String tokenConfirmacao;
    @JsonIgnore
    @Column(name = "token_recuperacao", length = 255)
    private String tokenRecuperacao;
    @JsonIgnore
    @Column(name = "expiracao_token")
    private LocalDateTime expiracaoToken;
    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @PrePersist
    void prePersist() {
        if (dataCadastro == null)
            dataCadastro = LocalDateTime.now();
        if (statusConta == null)
            statusConta = "ATIVO";
    }

    @PreUpdate
    void preUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long v) {
        id = v;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String v) {
        nome = v;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String v) {
        email = v;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String v) {
        username = v;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String v) {
        password = v;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String v) {
        cpf = v;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String v) {
        telefone = v;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] v) {
        foto = v;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String v) {
        perfil = v;
    }

    public String getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(String v) {
        statusConta = v;
    }

    public String getTokenConfirmacao() {
        return tokenConfirmacao;
    }

    public void setTokenConfirmacao(String v) {
        tokenConfirmacao = v;
    }

    public String getTokenRecuperacao() {
        return tokenRecuperacao;
    }

    public void setTokenRecuperacao(String v) {
        tokenRecuperacao = v;
    }

    public LocalDateTime getExpiracaoToken() {
        return expiracaoToken;
    }

    public void setExpiracaoToken(LocalDateTime v) {
        expiracaoToken = v;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime v) {
        dataCadastro = v;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime v) {
        dataAtualizacao = v;
    }
}
