package com.climacidades.asoares.climacidades.model;

/**
 * Created by asoares on 17/02/16.
 */
public class Coordenadas
{
    private Double longitude;
    private Double latitude;

    public Coordenadas() {
    }

    public Coordenadas(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
