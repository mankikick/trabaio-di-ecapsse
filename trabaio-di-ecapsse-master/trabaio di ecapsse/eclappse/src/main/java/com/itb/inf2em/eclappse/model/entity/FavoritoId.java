package com.itb.inf2em.eclappse.model.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavoritoId implements Serializable {
    @Column(name = "usuario_id")
    private Long usuarioId;
    @Column(name = "caso_id")
    private Long casoId;

    public FavoritoId() {
    }

    public FavoritoId(Long usuarioId, Long casoId) {
        this.usuarioId = usuarioId;
        this.casoId = casoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long v) {
        usuarioId = v;
    }

    public Long getCasoId() {
        return casoId;
    }

    public void setCasoId(Long v) {
        casoId = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof FavoritoId f))
            return false;
        return Objects.equals(usuarioId, f.usuarioId) && Objects.equals(casoId, f.casoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, casoId);
    }
}
