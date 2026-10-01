package com.itb.inf2em.eclappse.model.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="Notificacao")
public class Notificacao {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="usuario_destino_id",nullable=false) private Usuario usuarioDestino;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="caso_id",nullable=false) private Caso caso;
 @Column(nullable=false,length=100) private String titulo;
 @Column(nullable=false,length=500) private String mensagem;
 @Column(nullable=false) private boolean lida=false;
 @Column(name="data_envio",nullable=false,updatable=false) private LocalDateTime dataEnvio;
 @PrePersist void prePersist(){if(dataEnvio==null)dataEnvio=LocalDateTime.now();}
 public Long getId(){return id;} public void setId(Long v){id=v;} public Usuario getUsuarioDestino(){return usuarioDestino;} public void setUsuarioDestino(Usuario v){usuarioDestino=v;} public Caso getCaso(){return caso;} public void setCaso(Caso v){caso=v;} public String getTitulo(){return titulo;} public void setTitulo(String v){titulo=v;} public String getMensagem(){return mensagem;} public void setMensagem(String v){mensagem=v;} public boolean isLida(){return lida;} public void setLida(boolean v){lida=v;} public LocalDateTime getDataEnvio(){return dataEnvio;} public void setDataEnvio(LocalDateTime v){dataEnvio=v;}
}
