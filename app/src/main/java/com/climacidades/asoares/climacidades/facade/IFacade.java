package com.climacidades.asoares.climacidades.facade;

import com.climacidades.asoares.climacidades.model.MonitoramentoCidades;

import java.util.List;

/**
 * Created by asoares on 17/02/16.
 */
public interface IFacade {

    List<MonitoramentoCidades> getDadosClimaCidades(Double latitude, Double longitude);
}
