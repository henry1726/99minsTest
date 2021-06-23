package com.example.a99minstest.ui.main;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import com.example.a99minstest.R;
import com.example.a99minstest.data.entities.CodesMex;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.a99minstest.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private MainActivityViewModel viewModel;
    private List<List<HashMap<String, String>>> routes = new ArrayList<>();
    private List<HashMap<String, String>> path = new ArrayList<>();
    private HashMap<String, String> hm = new HashMap<>();



    @SuppressLint("VisibleForTests")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        viewModel.getInfo().observe(this, this::setModel);
        observeStreams();

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        viewModel.getCoordenadas().observe(this, result ->{

            LatLng center = new LatLng(-99.243015169286, 19.3858831605828);
            ArrayList<LatLng> points;
            PolylineOptions lineOptions;

            if(result.size() > 0){
                center = new LatLng(result.get(0).getLatitud(), result.get(0).getLongitud());
                points = new ArrayList<>();
                lineOptions = new PolylineOptions();
                for(int i = 0; i<result.size(); i++){
                    LatLng position = new LatLng(result.get(i).getLatitud(), result.get(i).getLongitud());
                    points.add(position);
                }

                // Agregamos todos los puntos en la ruta al objeto LineOptions
                lineOptions.addAll(points);
                //Definimos el grosor de las Polilíneas
                lineOptions.width(10);
                //Definimos el color de la Polilíneas
                lineOptions.color(Color.BLACK);

                mMap.addPolyline(lineOptions);

                LatLng origen = new LatLng(result.get(0).getLatitud(), result.get(0).getLongitud());
                mMap.addMarker(new MarkerOptions().position(origen).title("Lat: "+result.get(0).getLatitud()+" - Long: "+result.get(0).getLongitud()));

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center, 14));
            }else{

                LatLng origen = new LatLng(19.3858831605828, -99.243015169286);
                mMap.addMarker(new MarkerOptions().position(origen).title("Lat: 99.243015169286 - Long: 19.3858831605828"));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center, 14));
                Toast.makeText(this, "No se pudieron descargar las coordenadas", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void observeStreams(){
        viewModel.downloadCodes();
        viewModel.downloadCodesMex();
    }

    public void setModel(CodesMex codesMex){
        if(codesMex != null)
            binding.setModel(codesMex);
    }
}