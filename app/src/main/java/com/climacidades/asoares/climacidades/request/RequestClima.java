package com.climacidades.asoares.climacidades.request;

import com.climacidades.asoares.climacidades.model.Coordenadas;
import com.climacidades.asoares.climacidades.model.DadosMeteorologicos;
import com.climacidades.asoares.climacidades.model.DadosTempo;
import com.climacidades.asoares.climacidades.model.DadosVento;
import com.climacidades.asoares.climacidades.model.MonitoramentoCidades;
import com.climacidades.asoares.climacidades.utility.Constantes;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asoares on 17/02/16.
 */
public class RequestClima extends RequestBase{

    private List<MonitoramentoCidades> mMonitoramentoCidadesList;

    public RequestClima() {
    }

    public List<MonitoramentoCidades> getDadosClimaCidades(Double latitude, Double longitude)
    {
        mMonitoramentoCidadesList = new ArrayList<>();

        try
        {
            String retorno = "";
            JSONObject jsonObject;

            Constantes.setURLAPICLIMA(Double.toString(latitude), Double.toString(longitude));
            /**requisition to API**/
            retorno = this.execute(this).get();

            if(!retorno.trim().equals("error"))
            {
                /**carregando o json com os dados de retorno da api**/
                jsonObject = new JSONObject(retorno);

                JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray("list").toString());

                for (int i=0; i< jsonArray.length(); i++)
                {
                    MonitoramentoCidades monitoramentoCidades = new MonitoramentoCidades();

                    /**preenchendo os dados de coordenadas**/
                    Coordenadas coordenadas = preencherCoordenadas(jsonArray.getJSONObject(i).getJSONObject("coord"));
                    /**preenchendo os dados meteorologicos**/
                    DadosMeteorologicos dadosMeteorologicos = preencherDadosMeteorologicos(jsonArray.getJSONObject(i).getJSONObject("main"));
                    /**preenchendo os dados de vento**/
                    DadosVento dadosVento = preencherDadosVento(jsonArray.getJSONObject(i).getJSONObject("wind"));
                    /**preenchendo os dados de tempo**/
                    List<DadosTempo> dadosTempos = preencherDadosTempo(jsonArray.getJSONObject(i).getJSONArray("weather"));




                    /**preenchendo o objeto principal**/
                    monitoramentoCidades.setDataPrevista(jsonArray.getJSONObject(i).getString("dt"));
                    monitoramentoCidades.setId(jsonArray.getJSONObject(i).getString("id"));
                    monitoramentoCidades.setNomeCidade(jsonArray.getJSONObject(i).getString("name"));

                    monitoramentoCidades.setCoordenadas(coordenadas);
                    monitoramentoCidades.setDadosMeteorologicos(dadosMeteorologicos);
                    monitoramentoCidades.setDadosVento(dadosVento);
                    monitoramentoCidades.setDadosTempo(dadosTempos);

                    mMonitoramentoCidadesList.add(monitoramentoCidades);
                }

                return mMonitoramentoCidadesList;
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    private DadosVento preencherDadosVento(JSONObject jsonObjectDados)
    {
        try
        {
            if(jsonObjectDados != null)
            {
                DadosVento dadosVento = new DadosVento();

                dadosVento.setDirecaoVento(Double.parseDouble(jsonObjectDados.getString("deg")));
                dadosVento.setVelocidadeVento(Double.parseDouble(jsonObjectDados.getString("speed")));

                return dadosVento;
            }
            else
            {
                return null;
            }

        }
        catch (Exception e)
        {
            return null;
        }

    }

    private List<DadosTempo> preencherDadosTempo(JSONArray jsonArrayDados)
    {
        try
        {
            List<DadosTempo> listDadosTempo = new ArrayList<>();

            if(jsonArrayDados != null)
            {
                for (int i=0; i<jsonArrayDados.length(); i++)
                {
                    DadosTempo dadosTempo = new DadosTempo();
                    JSONObject jsonObject = jsonArrayDados.getJSONObject(i);

                    dadosTempo.setDescricao(jsonObject.getString("description"));
                    dadosTempo.setTempo(jsonObject.getString("main"));
                    dadosTempo.setId(Integer.parseInt(jsonObject.getString("id")));
                    dadosTempo.setIcone(jsonObject.getString("icon"));


                    listDadosTempo.add(dadosTempo);
                }

                return listDadosTempo;
            }
            else
            {
                return null;
            }

        }
        catch(Exception e)
        {
            return null;
        }

    }

    private DadosMeteorologicos preencherDadosMeteorologicos(JSONObject jsonObjectDados)
    {
        try
        {
            if(jsonObjectDados != null)
            {
                DadosMeteorologicos dadosMeteorologicos = new DadosMeteorologicos();

                dadosMeteorologicos.setHumidade(Integer.parseInt(jsonObjectDados.getString("humidity")));
//                dadosMeteorologicos.setPressaoNivelDoMar(Double.parseDouble(jsonObjectDados.getString("sea_level")));
//                dadosMeteorologicos.setPressaoNivelDoMarPadrao(Double.parseDouble(jsonObjectDados.getString("pressure")));
//                dadosMeteorologicos.setPressaoNivelDoSolo(Double.parseDouble(jsonObjectDados.getString("grnd_level")));
                dadosMeteorologicos.setTemperatura(Double.parseDouble(jsonObjectDados.getString("temp")));
                dadosMeteorologicos.setTemperaturaMaxima(Double.parseDouble(jsonObjectDados.getString("temp_max")));
                dadosMeteorologicos.setTemperaturaMinima(Double.parseDouble(jsonObjectDados.getString("temp_min")));

                return dadosMeteorologicos;
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            return null;
        }

    }

    private Coordenadas preencherCoordenadas(JSONObject jsonObjectDados)
    {
        try
        {
            if(jsonObjectDados != null)
            {
                Coordenadas coordenadas = new Coordenadas();
                coordenadas.setLatitude(Double.parseDouble(jsonObjectDados.getString("lon")));
                coordenadas.setLongitude(Double.parseDouble(jsonObjectDados.getString("lat")));

                return coordenadas;
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            return null;
        }

    }

}
