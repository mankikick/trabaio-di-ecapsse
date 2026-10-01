package com.itb.inf2em.eclappse.model.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="Penalidade")
public class Penalidade {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="usuario_infrator_id",nullable=false) private Usuario usuarioInfrator;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="admin_id",nullable=false) private Usuario admin;
 @Column(name="tipo_penalidade",nullable=false,length=30) private String tipoPenalidade;
 @Column(nullable=false,columnDefinition="VARCHAR(MAX)") private String motivo;
 @Column(name="data_inicio",nullable=false) private LocalDateTime dataInicio;
 @Column(name="data_fim") private LocalDateTime dataFim;
 @PrePersist void prePersist(){if(dataInicio==null)dataInicio=LocalDateTime.now();}
 public Long getId(){return id;} public void setId(Long v){id=v;} public Usuario getUsuarioInfrator(){return usuarioInfrator;} public void setUsuarioInfrator(Usuario v){usuarioInfrator=v;} public Usuario getAdmin(){return admin;} public void setAdmin(Usuario v){admin=v;} public String getTipoPenalidade(){return tipoPenalidade;} public void setTipoPenalidade(String v){tipoPenalidade=v;} public String getMotivo(){return motivo;} public void setMotivo(String v){motivo=v;} public LocalDateTime getDataInicio(){return dataInicio;} public void setDataInicio(LocalDateTime v){dataInicio=v;} public LocalDateTime getDataFim(){return dataFim;} public void setDataFim(LocalDateTime v){dataFim=v;}
}
