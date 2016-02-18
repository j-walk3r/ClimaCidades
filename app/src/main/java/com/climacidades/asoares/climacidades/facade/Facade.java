package com.climacidades.asoares.climacidades.facade;

import com.climacidades.asoares.climacidades.model.MonitoramentoCidades;
import com.climacidades.asoares.climacidades.request.RequestClima;

import java.util.List;

/**
 * Created by asoares on 17/02/16.
 */
public class Facade implements IFacade {
    @Override
    public List<MonitoramentoCidades> getDadosClimaCidades(Double latitude, Double longitude) {
        RequestClima requestClima = new RequestClima();
        return requestClima.getDadosClimaCidades(latitude,longitude);
    }
}
