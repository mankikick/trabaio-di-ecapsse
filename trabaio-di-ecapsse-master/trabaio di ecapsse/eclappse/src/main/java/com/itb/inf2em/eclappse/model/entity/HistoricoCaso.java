package com.itb.inf2em.eclappse.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "HistoricoCaso")
public class HistoricoCaso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "caso_id", nullable = false)
    private Caso caso;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @Column(name = "status_anterior", nullable = false, length = 30)
    private String statusAnterior;
    @Column(name = "status_novo", nullable = false, length = 30)
    private String statusNovo;
    @Column(name = "descricao_alteracao", nullable = false, columnDefinition = "VARCHAR(MAX)")
    private String descricaoAlteracao;
    @Column(name = "data_registro", nullable = false, updatable = false)
    private LocalDateTime dataRegistro;

    @PrePersist
    void prePersist() {
        if (dataRegistro == null)
            dataRegistro = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long v) {
        id = v;
    }

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso v) {
        caso = v;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario v) {
        usuario = v;
    }

    public String getStatusAnterior() {
        return statusAnterior;
    }

    public void setStatusAnterior(String v) {
        statusAnterior = v;
    }

    public String getStatusNovo() {
        return statusNovo;
    }

    public void setStatusNovo(String v) {
        statusNovo = v;
    }

    public String getDescricaoAlteracao() {
        return descricaoAlteracao;
    }

    public void setDescricaoAlteracao(String v) {
        descricaoAlteracao = v;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime v) {
        dataRegistro = v;
    }
}
