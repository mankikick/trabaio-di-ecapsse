package com.itb.inf2em.eclappse.model.entity;


import jakarta.persistence.*;

@Entity
@Table (name = "HistoricoCaso")
public class HistoricoCaso {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "caso_id", nullable = false)
        private Caso caso;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "usuario_id", nullable = false)
        private Usuario usuario;
        @Column(name = "status_anterior", nullable = false)
        private boolean statusAnterior;
        @Column(name = "status_novo", nullable = false)
        private boolean statusNovo;
        @Column(name = "descricao_alteracao")
        private String descricaoAlteracao;
        @Column(name = "data_registro", nullable = false)
        private String dataRegistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso caso) {
        this.caso = caso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isStatusAnterior() {
        return statusAnterior;
    }

    public void setStatusAnterior(boolean statusAnterior) {
        this.statusAnterior = statusAnterior;
    }

    public boolean isStatusNovo() {
        return statusNovo;
    }

    public void setStatusNovo(boolean statusNovo) {
        this.statusNovo = statusNovo;
    }

    public String getDescricaoAlteracao() {
        return descricaoAlteracao;
    }

    public void setDescricaoAlteracao(String descricaoAlteracao) {
        this.descricaoAlteracao = descricaoAlteracao;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
