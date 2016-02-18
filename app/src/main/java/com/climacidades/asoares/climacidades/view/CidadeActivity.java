package com.climacidades.asoares.climacidades.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.climacidades.asoares.climacidades.R;
import com.climacidades.asoares.climacidades.adapter.CidadeAdapter;
import com.climacidades.asoares.climacidades.facade.Facade;
import com.climacidades.asoares.climacidades.fragments.MapFragment;
import com.climacidades.asoares.climacidades.model.MonitoramentoCidades;
import com.climacidades.asoares.climacidades.utility.Divider;
import com.climacidades.asoares.climacidades.utility.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asoares on 18/02/16.
 */
public class CidadeActivity extends AppCompatActivity {

    private RecyclerView recycleViewCidades;
    private Facade facade;
    public static List<MonitoramentoCidades> mMonitoramentoCidadesList;
    private static ProgressDialog pd = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cidade);


        recycleViewCidades = (RecyclerView)findViewById(R.id.rvCidade);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recycleViewCidades.setLayoutManager(llm);
        recycleViewCidades.addItemDecoration(new Divider(this));


        startProgressDialog("","Aguarde, localizando cidades...");
        new Thread(new Runnable() {
            @Override
            public void run()
            {
                facade = new Facade();
                mMonitoramentoCidadesList = new ArrayList<MonitoramentoCidades>();

                /**carregamento dos dados de clima das cidades**/
                mMonitoramentoCidadesList = facade.getDadosClimaCidades(MapFragment.mLatLng.latitude, MapFragment.mLatLng.longitude);

                if(mMonitoramentoCidadesList != null)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            /**colocando o resultado da api no adapter para criar a lista**/
                            CidadeAdapter cidadeAdapter = new CidadeAdapter(CidadeActivity.this, mMonitoramentoCidadesList);
                            recycleViewCidades.setAdapter(cidadeAdapter);
                            stopProgressDialog();
                        }
                    });

                }
            }
        }).start();


        recycleViewCidades.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Log.i("POSIÇÃO", String.valueOf(position));
                        //Toast.makeText(CidadeActivity.this, ""+position, Toast.LENGTH_SHORT).show();

                        Bundle bundle = new Bundle();
                        bundle.putInt("posicao", position);

                        Intent it = new Intent(CidadeActivity.this, DetalhesCidadeActivity.class);

                        it.putExtras(bundle);

                        startActivity(it);
                    }
                })
        );
    }

    public void startProgressDialog(String Title, String Message)
    {
        pd = new ProgressDialog(CidadeActivity.this);
        pd.setTitle(Title);
        pd.setMessage(Message);
        pd.setCancelable(false);
        pd.setIndeterminate(true);
        pd.show();
    }

    public void stopProgressDialog()
    {
        pd.dismiss();
    }
}
