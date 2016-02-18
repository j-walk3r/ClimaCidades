package com.climacidades.asoares.climacidades.view;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.climacidades.asoares.climacidades.facade.Facade;
import com.climacidades.asoares.climacidades.fragments.MapFragment;
import com.climacidades.asoares.climacidades.R;
import com.climacidades.asoares.climacidades.model.MonitoramentoCidades;
import com.google.android.gms.maps.GoogleMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asoares on 16/02/16.
 */
public class MainActivity extends AppCompatActivity{

    private Button buttonBuscar;


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBuscar = (Button)findViewById(R.id.btnBuscar);

        buttonBuscar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent it = new Intent(MainActivity.this, CidadeActivity.class);
                startActivity(it);
            }
        });

        /**cria uma instancia do fragment que possui o mapa**/
        showMap();

    }

    private void showMap() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_map, MapFragment.newInstance()).commitAllowingStateLoss();
    }
}
