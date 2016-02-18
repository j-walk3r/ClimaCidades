package com.climacidades.asoares.climacidades.model;

import java.util.List;

/**
 * Created by asoares on 17/02/16.
 */
public class MonitoramentoCidades {

    private String id;
    private String nomeCidade;
    private Coordenadas coordenadas;
    private DadosMeteorologicos dadosMeteorologicos;
    private String dataPrevista;
    private DadosVento dadosVento;
    private List<DadosTempo> dadosTempo;


    public MonitoramentoCidades() {
    }

    public MonitoramentoCidades(String id, String nomeCidade, Coordenadas coordenadas, DadosMeteorologicos dadosMeteorologicos, String dataPrevista, DadosVento dadosVento, List<DadosTempo> dadosTempo) {
        this.id = id;
        this.nomeCidade = nomeCidade;
        this.coordenadas = coordenadas;
        this.dadosMeteorologicos = dadosMeteorologicos;
        this.dataPrevista = dataPrevista;
        this.dadosVento = dadosVento;
        this.dadosTempo = dadosTempo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public DadosMeteorologicos getDadosMeteorologicos() {
        return dadosMeteorologicos;
    }

    public void setDadosMeteorologicos(DadosMeteorologicos dadosMeteorologicos) {
        this.dadosMeteorologicos = dadosMeteorologicos;
    }

    public String getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(String dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public DadosVento getDadosVento() {
        return dadosVento;
    }

    public void setDadosVento(DadosVento dadosVento) {
        this.dadosVento = dadosVento;
    }

    public List<DadosTempo> getDadosTempo() {
        return dadosTempo;
    }

    public void setDadosTempo(List<DadosTempo> dadosTempo) {
        this.dadosTempo = dadosTempo;
    }
}
