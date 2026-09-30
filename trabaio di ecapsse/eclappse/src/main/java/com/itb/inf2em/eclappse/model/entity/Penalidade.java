package com.itb.inf2em.eclappse.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "Penalidade")
public class Penalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_infrator_id", nullable = false)
    private Usuario usuarioInfrator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", nullable = false)
    private Usuario admin;

    @Column(name = "tipo_penalidade", nullable = false, length = 50)
    private String tipoPenalidade;

    @Column(nullable = false, columnDefinition = "VARCHAR(MAX)")
    private String motivo;

    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuarioInfrator() {
        return usuarioInfrator;
    }

    public void setUsuarioInfrator(Usuario usuarioInfrator) {
        this.usuarioInfrator = usuarioInfrator;
    }

    public Usuario getAdmin() {
        return admin;
    }

    public void setAdmin(Usuario admin) {
        this.admin = admin;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public String getTipoPenalidade() {
        return tipoPenalidade;
    }

    public void setTipoPenalidade(String tipoPenalidade) {
        this.tipoPenalidade = tipoPenalidade;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }


}