package com.climacidades.asoares.climacidades.utility;

/**
 * Created by asoares on 17/02/16.
 */
public class Constantes {

    private static String URLAPI = "";

    public static String getURLAPICLIMA() {
        return URLAPI;
    }

    public static void setURLAPICLIMA(String latitude, String longitude) {
        Constantes.URLAPI = "http://api.openweathermap.org/data/2.5/find?lat="+latitude+"%7BLAT%7D&lon="+longitude+"%7BLON%7D&cnt=15&APPID=d5e5e7bf0036493556227d17d41219bd";
    }
}
