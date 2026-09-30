package com.itb.inf2em.eclappse.model.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "ModeracaoConteudo")
public class ModeracaoConteudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "caso_id", insertable = false, updatable = false)
    private Long casoId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caso_id", nullable = false)
    private Caso caso;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_autor_id", nullable = false)
    private Usuario usuarioAutor;
    @Column(name = "conteudo_texto")
    private String conteudoTexto;
    @Column(name = "status_conteudo")
    private boolean statusConteudo;
    @Column(name = "motivo_denuncia")
    private String motivoDenuncia;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCasoId() {
        return casoId;
    }

    public void setCasoId(Long casoId) {
        this.casoId = casoId;
    }

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso caso) {
        this.caso = caso;
    }

    public Usuario getUsuarioAutor() {
        return usuarioAutor;
    }

    public void setUsuarioAutor(Usuario usuarioAutor) {
        this.usuarioAutor = usuarioAutor;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getConteudoTexto() {
        return conteudoTexto;
    }

    public void setConteudoTexto(String conteudoTexto) {
        this.conteudoTexto = conteudoTexto;
    }

    public boolean isStatusConteudo() {
        return statusConteudo;
    }

    public void setStatusConteudo(boolean statusConteudo) {
        this.statusConteudo = statusConteudo;
    }

    public String getMotivoDenuncia() {
        return motivoDenuncia;
    }

    public void setMotivoDenuncia(String motivoDenuncia) {
        this.motivoDenuncia = motivoDenuncia;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}