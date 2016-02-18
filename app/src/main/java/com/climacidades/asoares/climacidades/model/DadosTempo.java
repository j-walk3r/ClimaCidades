package com.climacidades.asoares.climacidades.model;

/**
 * Created by asoares on 17/02/16.
 */
public class DadosTempo
{
    private int id;
    private String tempo;
    private String descricao;
    private String icone;

    public DadosTempo() {
    }

    public DadosTempo(int id, String tempo, String descricao, String icone) {
        this.id = id;
        this.tempo = tempo;
        this.descricao = descricao;
        this.icone = icone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }
}
