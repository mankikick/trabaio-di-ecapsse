package com.itb.inf2em.eclappse.model.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "Avistamento")
public class Avistamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "caso_id", nullable = false)
    private Long casoId;
    @JoinColumn(name = "caso_id", nullable = false)
    private Long colaboradorId;
    @Column(name = "data_avistamento", nullable = false)
    private String dataAvistamento;
    @Column(name = "descricao_detalhada", nullable = false, columnDefinition = "VARCHAR(MAX)")
    private String descricaoDetalhada;
    @Column(name = "logradouro", nullable = false, length = 100)
    private String logradouro;
    @Column(name = "numero", length = 10)
    private int numero;
    @Column(name = "bairro", nullable = false, length = 100)
    private String bairro;
    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;
    @Column(name = "uf", nullable = false, length = 2)
    private String uf;
    @Column(name = "cep", length = 8)
    private String cep;
    @Column(name = "ponto_referencia", length = 100)
    private String pontoReferencia;
    @Column(name = "latitude", length = 100)
    private Double latitude;
    @Column(name = "longitude", length = 100)
    private Double longitude;
    @Column(name = "foto_evidencia", columnDefinition = "VARBINARY(MAX)")
    private String fotoEvidencia;
    @Column(name = "data_registro", nullable = false)
    private boolean statusAvistamento;

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

    public Long getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Long colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    public String getDataAvistamento() {
        return dataAvistamento;
    }

    public void setDataAvistamento(String dataAvistamento) {
        this.dataAvistamento = dataAvistamento;
    }

    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getFotoEvidencia() {
        return fotoEvidencia;
    }

    public void setFotoEvidencia(String fotoEvidencia) {
        this.fotoEvidencia = fotoEvidencia;
    }

    public boolean isStatusAvistamento() {
        return statusAvistamento;
    }

    public void setStatusAvistamento(boolean statusAvistamento) {
        this.statusAvistamento = statusAvistamento;
    }
}

