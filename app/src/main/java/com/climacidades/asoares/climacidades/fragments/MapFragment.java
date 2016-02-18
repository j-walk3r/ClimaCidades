package com.climacidades.asoares.climacidades.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.climacidades.asoares.climacidades.R;
import com.climacidades.asoares.climacidades.model.Coordenadas;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by asoares on 16/02/16.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {

    private static final String TAG = "MapFragment";
    private SupportMapFragment supportMapFragment;
    private View rootView;
    public static LatLng mLatLng;

    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();
        return fragment;
    }

    public MapFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate...");
        if( savedInstanceState != null )
        {
            Log.d(TAG, "onCreate..." + savedInstanceState.getDouble("latitude") +"////"+savedInstanceState.getDouble("longitude"));
            savePosition(savedInstanceState.getDouble("latitude"), savedInstanceState.getDouble("longitude"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        supportMapFragment = SupportMapFragment.newInstance();
        rootView = inflater.inflate(R.layout.fragment_map, null);
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.beginTransaction().replace(R.id.map, supportMapFragment).commitAllowingStateLoss();
        }
        supportMapFragment.getMapAsync(this);
        return rootView;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        configBasicMap(googleMap);

    }

    private void configBasicMap(final GoogleMap googleMap) {

        /**Cria uma coordenada de ponto para o mapa**/
        savePosition(-8.063646, -34.872773);
        MarkerOptions markerOptions = new MarkerOptions()
                .position(mLatLng)
                .draggable(true);

        /**Configura o zoom da camera do mapa**/
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mLatLng, 13));

        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

        /**Adiciona a marcacao no mapa**/
        googleMap.addMarker(markerOptions);

        /** chamado quando o mapa recebe um click **/
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Log.d(TAG, "onMapClick..." + latLng.latitude + "..." + latLng.longitude);
                savePosition(latLng.latitude, latLng.longitude);

                googleMap.clear();
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                googleMap.addMarker(new MarkerOptions()
                                    .draggable(true)
                                    .position(latLng));
            }
        });

        googleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {

            /** chamado quando é segurado o marker **/
            @Override
            public void onMarkerDragStart(Marker marker) {
                // TODO Auto-generated method stub
                Log.d(TAG, "onMarkerDragStart..." + marker.getPosition().latitude + "..." + marker.getPosition().longitude);
                savePosition(marker.getPosition().latitude, marker.getPosition().longitude);
            }

            /** chamado quando o marker esta selecionado **/
            @Override
            public void onMarkerDrag(Marker marker) {
                // TODO Auto-generated method stub
                Log.d(TAG, "onMarkerDrag..." + marker.getPosition().latitude + "..." + marker.getPosition().longitude);
                savePosition(marker.getPosition().latitude, marker.getPosition().longitude);
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(marker.getPosition()));
            }


            /** chamado quando o marker for solto **/
            @Override
            public void onMarkerDragEnd(Marker marker) {
                // TODO Auto-generated method stub
                Log.d(TAG, "onMarkerDragEnd..." + marker.getPosition().latitude + "..." + marker.getPosition().longitude);
                savePosition(marker.getPosition().latitude, marker.getPosition().longitude);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("latitude", mLatLng.latitude);
        outState.putDouble("longitude", mLatLng.longitude);

        Log.d(TAG, "onSaveInstanceState..." + mLatLng.latitude + "////" + mLatLng.longitude);
    }

    private void savePosition(Double latitude, Double longitude)
    {
        mLatLng = new LatLng(latitude, longitude);
    }

}
