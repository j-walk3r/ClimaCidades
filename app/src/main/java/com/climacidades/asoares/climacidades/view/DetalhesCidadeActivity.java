package com.climacidades.asoares.climacidades.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.climacidades.asoares.climacidades.R;
import com.climacidades.asoares.climacidades.model.MonitoramentoCidades;

import java.util.List;

/**
 * Created by asoares on 18/02/16.
 */
public class DetalhesCidadeActivity extends AppCompatActivity{

    private MonitoramentoCidades mMonitoramentoCidades;
    private int position;

    private TextView tvTpMaxima;
    private TextView tvNomeCidade;
    private TextView tvTpMinima;
    private TextView tvDescTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_cidade);


        /**recuperando a posicao da lista de MonitoramentoCidades**/
        Intent intent = getIntent();
        Bundle params = intent.getExtras();

        if(params!=null)
        {
            position = params.getInt("posicao");
        }

        /**recuperando o id dos itens da tela**/
        tvTpMaxima = (TextView)findViewById(R.id.tvTpMaxima);
        tvNomeCidade = (TextView)findViewById(R.id.tvNomeCidade);
        tvTpMinima  = (TextView)findViewById(R.id.tvTpMinima);
        tvDescTempo = (TextView)findViewById(R.id.tvDescTempo);

        /**preenchendo o objeto MonitoramentoCidades**/
        mMonitoramentoCidades = CidadeActivity.mMonitoramentoCidadesList.get(position);


        /**carregando text nos itens**/
        if(mMonitoramentoCidades != null)
        {
            tvNomeCidade.setText(mMonitoramentoCidades.getNomeCidade());
            tvDescTempo.setText("Descricao do Tempo: "+ mMonitoramentoCidades.getDadosTempo().get(0).getDescricao());
            tvTpMaxima.setText("Temperatura Maxima: "+ mMonitoramentoCidades.getDadosMeteorologicos().getTemperaturaMaxima().toString()+"°C");
            tvTpMinima.setText("Temperatura Minima: " + mMonitoramentoCidades.getDadosMeteorologicos().getTemperaturaMinima().toString()+"°C");
        }


    }
}
