package com.gurgur.androidgooglemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    Float zoom = 12.0f;
    Button btn_zoom_in,btn_zoom_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        btn_zoom_in = findViewById(R.id.button2);
        btn_zoom_out = findViewById(R.id.button3);
        btn_zoom_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        zoom = zoom + 2.0f;
                        Double lat_ = 40.995923;
                        Double lon_ = 28.879249;
                        googleMap.addMarker(new MarkerOptions().position(new LatLng(lat_,lon_)).title("Bakırköy Adliyesi"));
                        googleMap.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(lat_,lon_) , zoom) );
                    }
                });
            }
        });
        btn_zoom_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        zoom = zoom - 2.0f;
                        Double lat_ = 40.995923;
                        Double lon_ = 28.879249;
                        googleMap.addMarker(new MarkerOptions().position(new LatLng(lat_,lon_)).title("Bakırköy Adliyesi"));
                        googleMap.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(lat_,lon_) , zoom) );
                    }
                });
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        Double lat_ = 40.995923;
        Double lon_ = 28.879249;
        googleMap.addMarker(new MarkerOptions().position(new LatLng(lat_,lon_)).title("Bakırköy Adliyesi"));
        googleMap.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(lat_,lon_) , 12.0f) );
    }
}
