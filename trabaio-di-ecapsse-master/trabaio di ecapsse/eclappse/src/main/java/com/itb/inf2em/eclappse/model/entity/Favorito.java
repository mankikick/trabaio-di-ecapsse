package com.itb.inf2em.eclappse.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Favorito")
public class Favorito {
    @EmbeddedId
    private FavoritoId id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("casoId")
    @JoinColumn(name = "caso_id", nullable = false)
    private Caso caso;
    @Column(name = "data_favoritado", nullable = false, updatable = false)
    private LocalDateTime dataFavoritado;

    @PrePersist
    void prePersist() {
        if (dataFavoritado == null)
            dataFavoritado = LocalDateTime.now();
    }

    public FavoritoId getId() {
        return id;
    }

    public void setId(FavoritoId v) {
        id = v;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario v) {
        usuario = v;
    }

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso v) {
        caso = v;
    }

    public LocalDateTime getDataFavoritado() {
        return dataFavoritado;
    }

    public void setDataFavoritado(LocalDateTime v) {
        dataFavoritado = v;
    }
}
