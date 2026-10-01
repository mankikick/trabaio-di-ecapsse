package com.itb.inf2em.eclappse.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Caso")
public class Caso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_responsavel_id", nullable = false)
    private Usuario usuarioResponsavel;
    @Column(name = "nome_desaparecido", nullable = false, length = 100)
    private String nomeDesaparecido;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "data_desaparecimento", nullable = false)
    private LocalDate dataDesaparecimento;
    @Column(name = "local_desaparecimento", nullable = false, length = 255)
    private String localDesaparecimento;
    @Column(name = "caracteristicas_fisicas", columnDefinition = "VARCHAR(MAX)")
    private String caracteristicasFisicas;
    @Column(name = "circunstancias", columnDefinition = "VARCHAR(MAX)")
    private String circunstancias;
    @Column(name = "foto", columnDefinition = "VARBINARY(MAX)")
    private byte[] foto;
    @Column(name = "status_caso", nullable = false, length = 30)
    private String statusCaso = "ATIVO";
    @Column(name = "solicitacao_exclusao", nullable = false)
    private boolean solicitacaoExclusao = false;
    @Column(name = "motivo_exclusao", columnDefinition = "VARCHAR(MAX)")
    private String motivoExclusao;
    @Column(name = "data_registro", nullable = false, updatable = false)
    private LocalDateTime dataRegistro;
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @PrePersist
    void prePersist() {
        if (dataRegistro == null)
            dataRegistro = LocalDateTime.now();
        if (statusCaso == null)
            statusCaso = "ATIVO";
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

    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(Usuario v) {
        usuarioResponsavel = v;
    }

    public String getNomeDesaparecido() {
        return nomeDesaparecido;
    }

    public void setNomeDesaparecido(String v) {
        nomeDesaparecido = v;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate v) {
        dataNascimento = v;
    }

    public LocalDate getDataDesaparecimento() {
        return dataDesaparecimento;
    }

    public void setDataDesaparecimento(LocalDate v) {
        dataDesaparecimento = v;
    }

    public String getLocalDesaparecimento() {
        return localDesaparecimento;
    }

    public void setLocalDesaparecimento(String v) {
        localDesaparecimento = v;
    }

    public String getCaracteristicasFisicas() {
        return caracteristicasFisicas;
    }

    public void setCaracteristicasFisicas(String v) {
        caracteristicasFisicas = v;
    }

    public String getCircunstancias() {
        return circunstancias;
    }

    public void setCircunstancias(String v) {
        circunstancias = v;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] v) {
        foto = v;
    }

    public String getStatusCaso() {
        return statusCaso;
    }

    public void setStatusCaso(String v) {
        statusCaso = v;
    }

    public boolean isSolicitacaoExclusao() {
        return solicitacaoExclusao;
    }

    public void setSolicitacaoExclusao(boolean v) {
        solicitacaoExclusao = v;
    }

    public String getMotivoExclusao() {
        return motivoExclusao;
    }

    public void setMotivoExclusao(String v) {
        motivoExclusao = v;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime v) {
        dataRegistro = v;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime v) {
        dataAtualizacao = v;
    }
}
