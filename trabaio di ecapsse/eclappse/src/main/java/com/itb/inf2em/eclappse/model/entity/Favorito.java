package com.itb.inf2em.eclappse.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@Entity
@Table (name = "Favorito")
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long usuarioId;


    @Column(name = "caso_id", nullable = false)
    private Long casoId;

    @Column(name = "data_favorito")
    private String dataFavorito;


    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getCasoId() {
        return casoId;
    }

    public void setCasoId(Long casoId) {
        this.casoId = casoId;
    }

    public String getDataFavorito() {
        return dataFavorito;
    }

    public void setDataFavorito(String dataFavorito) {
        this.dataFavorito = dataFavorito;
    }
}