package com.itb.inf2em.eclappse.model.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="ModeraçãoConteudo")
public class ModeracaoConteudo {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="caso_id",nullable=false) private Caso caso;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="usuario_autor_id",nullable=false) private Usuario usuarioAutor;
 @Column(name="conteudo_texto",nullable=false,length=1000) private String conteudoTexto;
 @Column(name="status_conteudo",nullable=false,length=20) private String statusConteudo="EM_ANALISE";
 @Column(name="motivo_denuncia",length=255) private String motivoDenuncia;
 @Column(name="data_criacao",nullable=false,updatable=false) private LocalDateTime dataCriacao;
 @PrePersist void prePersist(){if(dataCriacao==null)dataCriacao=LocalDateTime.now();if(statusConteudo==null)statusConteudo="EM_ANALISE";}
 public Long getId(){return id;} public void setId(Long v){id=v;} public Caso getCaso(){return caso;} public void setCaso(Caso v){caso=v;} public Usuario getUsuarioAutor(){return usuarioAutor;} public void setUsuarioAutor(Usuario v){usuarioAutor=v;} public String getConteudoTexto(){return conteudoTexto;} public void setConteudoTexto(String v){conteudoTexto=v;} public String getStatusConteudo(){return statusConteudo;} public void setStatusConteudo(String v){statusConteudo=v;} public String getMotivoDenuncia(){return motivoDenuncia;} public void setMotivoDenuncia(String v){motivoDenuncia=v;} public LocalDateTime getDataCriacao(){return dataCriacao;} public void setDataCriacao(LocalDateTime v){dataCriacao=v;}
}
