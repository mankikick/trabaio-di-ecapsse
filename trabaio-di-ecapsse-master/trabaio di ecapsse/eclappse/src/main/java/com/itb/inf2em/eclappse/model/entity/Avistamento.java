package com.itb.inf2em.eclappse.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name="Avistamento")
public class Avistamento {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="caso_id",nullable=false) private Caso caso;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="colaborador_id",nullable=false) private Usuario colaborador;
 @Column(name="data_avistamento",nullable=false) private LocalDateTime dataAvistamento;
 @Column(name="descricao_detalhada",nullable=false,columnDefinition="VARCHAR(MAX)") private String descricaoDetalhada;
 @Column(nullable=false,length=100) private String logradouro;
 @Column(length=10) private String numero;
 @Column(nullable=false,length=100) private String bairro;
 @Column(nullable=false,length=100) private String cidade;
 @Column(nullable=false,length=2) private String uf;
 @Column(length=8) private String cep;
 @Column(name="ponto_referencia",length=100) private String pontoReferencia;
 @Column(length=100) private String latitude;
 @Column(length=100) private String longitude;
 @Column(name="foto_evidencia",columnDefinition="VARBINARY(MAX)") private byte[] fotoEvidencia;
 @Column(name="status_avistamento",nullable=false,length=20) private String statusAvistamento="EM_ANALISE";
 @Column(name="data_registro",nullable=false,updatable=false) private LocalDateTime dataRegistro;
 @PrePersist void prePersist(){if(dataRegistro==null)dataRegistro=LocalDateTime.now();if(statusAvistamento==null)statusAvistamento="EM_ANALISE";}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public Caso getCaso(){return caso;} public void setCaso(Caso v){caso=v;}
 public Usuario getColaborador(){return colaborador;} public void setColaborador(Usuario v){colaborador=v;}
 public LocalDateTime getDataAvistamento(){return dataAvistamento;} public void setDataAvistamento(LocalDateTime v){dataAvistamento=v;}
 public String getDescricaoDetalhada(){return descricaoDetalhada;} public void setDescricaoDetalhada(String v){descricaoDetalhada=v;}
 public String getLogradouro(){return logradouro;} public void setLogradouro(String v){logradouro=v;}
 public String getNumero(){return numero;} public void setNumero(String v){numero=v;}
 public String getBairro(){return bairro;} public void setBairro(String v){bairro=v;}
 public String getCidade(){return cidade;} public void setCidade(String v){cidade=v;}
 public String getUf(){return uf;} public void setUf(String v){uf=v;}
 public String getCep(){return cep;} public void setCep(String v){cep=v;}
 public String getPontoReferencia(){return pontoReferencia;} public void setPontoReferencia(String v){pontoReferencia=v;}
 public String getLatitude(){return latitude;} public void setLatitude(String v){latitude=v;}
 public String getLongitude(){return longitude;} public void setLongitude(String v){longitude=v;}
 public byte[] getFotoEvidencia(){return fotoEvidencia;} public void setFotoEvidencia(byte[] v){fotoEvidencia=v;}
 public String getStatusAvistamento(){return statusAvistamento;} public void setStatusAvistamento(String v){statusAvistamento=v;}
 public LocalDateTime getDataRegistro(){return dataRegistro;} public void setDataRegistro(LocalDateTime v){dataRegistro=v;}
}
