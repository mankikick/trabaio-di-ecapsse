package com.itb.inf2em.eclappse.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Auditoria")
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @Column(nullable = false, length = 100)
    private String acao;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @Column(name = "ip_origem", length = 45)
    private String ipOrigem;
    @Column(name = "data_acao", nullable = false, updatable = false)
    private LocalDateTime dataAcao;

    @PrePersist
    void prePersist() {
        if (dataAcao == null)
            dataAcao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long v) {
        id = v;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario v) {
        usuario = v;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String v) {
        acao = v;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String v) {
        descricao = v;
    }

    public String getIpOrigem() {
        return ipOrigem;
    }

    public void setIpOrigem(String v) {
        ipOrigem = v;
    }

    public LocalDateTime getDataAcao() {
        return dataAcao;
    }

    public void setDataAcao(LocalDateTime v) {
        dataAcao = v;
    }
}
