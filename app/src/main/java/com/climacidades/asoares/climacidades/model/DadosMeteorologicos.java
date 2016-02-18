package com.climacidades.asoares.climacidades.model;

/**
 * Created by asoares on 17/02/16.
 */
public class DadosMeteorologicos {

    private Double temperatura;
    private Double temperaturaMinima;
    private Double temperaturaMaxima;
    private Double pressaoNivelDoMarPadrao;
    private Double pressaoNivelDoMar;
    private Double pressaoNivelDoSolo;
    private int humidade;

    public DadosMeteorologicos() {
    }

    public DadosMeteorologicos(Double temperatura, Double temperaturaMinima, Double temperaturaMaxima, Double pressaoNivelDoMarPadrao, Double pressaoNivelDoMar, Double pressaoNivelDoSolo, int humidade) {
        this.temperatura = temperatura;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.pressaoNivelDoMarPadrao = pressaoNivelDoMarPadrao;
        this.pressaoNivelDoMar = pressaoNivelDoMar;
        this.pressaoNivelDoSolo = pressaoNivelDoSolo;
        this.humidade = humidade;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(Double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public Double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(Double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public Double getPressaoNivelDoMarPadrao() {
        return pressaoNivelDoMarPadrao;
    }

    public void setPressaoNivelDoMarPadrao(Double pressaoNivelDoMarPadrao) {
        this.pressaoNivelDoMarPadrao = pressaoNivelDoMarPadrao;
    }

    public Double getPressaoNivelDoMar() {
        return pressaoNivelDoMar;
    }

    public void setPressaoNivelDoMar(Double pressaoNivelDoMar) {
        this.pressaoNivelDoMar = pressaoNivelDoMar;
    }

    public Double getPressaoNivelDoSolo() {
        return pressaoNivelDoSolo;
    }

    public void setPressaoNivelDoSolo(Double pressaoNivelDoSolo) {
        this.pressaoNivelDoSolo = pressaoNivelDoSolo;
    }

    public int getHumidade() {
        return humidade;
    }

    public void setHumidade(int humidade) {
        this.humidade = humidade;
    }
}
