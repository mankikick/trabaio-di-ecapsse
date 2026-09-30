package com.itb.inf2em.eclappse.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "Caso")
public class Caso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_responsavel_id")
    private Usuario usuarioResponsavel;
    @Column(name = "nome_desaparecido")
    private String nomeDesaparecido;
    @Column(name = "data_nascimento")
    private String dataNascimento;
    @Column(name = "data_desaparecimento")
    private String dataDesaparecimento;
    @Column(name = "local_desaparecimento")
    private String localDesaparecimento;
    @Column(name = "caracteristicas_fisicas")
    private String caracteristicasFisicas;
    @Column(name = "circunstancias")
    private String circunstancias;
    @Column(name = "foto")
    private String foto;
    @Column(name = "status_caso")
    private boolean statusCaso;
    @Column(name = "solicitacao_exclusao")
    private String solicitacaoExclusao;
    @Column(name = "motivo_exclusao")
    private String motivoExclusao;
    @Column(name = "data_registro")
    private String dataRegistro;

    // @OneToMany(mappedBy = "caso")
    // private List<Avistamento> avistamentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public List<Avistamento> getAvistamentos() {
//        return avistamentos;
//    }

//    public void setAvistamentos(List<Avistamento> avistamentos) {
//        this.avistamentos = avistamentos;
//    }

    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }

    public String getNomeDesaparecido() {
        return nomeDesaparecido;
    }

    public void setNomeDesaparecido(String nomeDesaparecido) {
        this.nomeDesaparecido = nomeDesaparecido;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataDesaparecimento() {
        return dataDesaparecimento;
    }

    public void setDataDesaparecimento(String dataDesaparecimento) {
        this.dataDesaparecimento = dataDesaparecimento;
    }

    public String getLocalDesaparecimento() {
        return localDesaparecimento;
    }

    public void setLocalDesaparecimento(String localDesaparecimento) {
        this.localDesaparecimento = localDesaparecimento;
    }

    public String getCaracteristicasFisicas() {
        return caracteristicasFisicas;
    }

    public void setCaracteristicasFisicas(String caracteristicasFisicas) {
        this.caracteristicasFisicas = caracteristicasFisicas;
    }

    public String getCircunstancias() {
        return circunstancias;
    }

    public void setCircunstancias(String circunstancias) {
        this.circunstancias = circunstancias;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isStatusCaso() {
        return statusCaso;
    }

    public void setStatusCaso(boolean statusCaso) {
        this.statusCaso = statusCaso;
    }

    public String getSolicitacaoExclusao() {
        return solicitacaoExclusao;
    }

    public void setSolicitacaoExclusao(String solicitacaoExclusao) {
        this.solicitacaoExclusao = solicitacaoExclusao;
    }

    public String getMotivoExclusao() {
        return motivoExclusao;
    }

    public void setMotivoExclusao(String motivoExclusao) {
        this.motivoExclusao = motivoExclusao;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }


    }
