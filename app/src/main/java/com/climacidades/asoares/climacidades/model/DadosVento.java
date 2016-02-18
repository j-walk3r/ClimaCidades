package com.climacidades.asoares.climacidades.model;

/**
 * Created by asoares on 17/02/16.
 */
public class DadosVento {

    private Double velocidadeVento;
    private Double direcaoVento;

    public DadosVento() {
    }

    public DadosVento(Double velocidadeVento, Double direcaoVento) {
        this.velocidadeVento = velocidadeVento;
        this.direcaoVento = direcaoVento;
    }

    public Double getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(Double velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    public Double getDirecaoVento() {
        return direcaoVento;
    }

    public void setDirecaoVento(Double direcaoVento) {
        this.direcaoVento = direcaoVento;
    }
}
