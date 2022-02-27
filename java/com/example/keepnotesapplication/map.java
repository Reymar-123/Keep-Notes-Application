package com.example.keepnotesapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.LatLng;

public class map extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

            map = googleMap;

        LatLng Pangasinan_Provincial_Library = new LatLng(16.047771965182545, 120.2693819172607);
        map.addMarker(new MarkerOptions().position(Pangasinan_Provincial_Library).title("Pangasinan Provincial Library"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Pangasinan_Provincial_Library,9), 5000, null);

        LatLng Public_Library_San_Carlos_City_Pangasinan = new LatLng(15.925317081602353, 120.34769760460803);
        map.addMarker(new MarkerOptions().position(Public_Library_San_Carlos_City_Pangasinan).title("Public Library San Carlos City Pangasinan"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Public_Library_San_Carlos_City_Pangasinan,9), 5000, null);


        LatLng Mangaldan_Municipal_Library = new LatLng(16.070300205400688, 120.40410788503014);
        map.addMarker(new MarkerOptions().position(Mangaldan_Municipal_Library).title("Mangaldan Municipal Library"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Mangaldan_Municipal_Library,9), 5000, null);

        LatLng BNHS_Library = new LatLng(15.85323598741152, 120.39881542550431);
        map.addMarker(new MarkerOptions().position(BNHS_Library).title("BNHS Library"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(BNHS_Library,9), 5000, null);

        LatLng Dagupan_E_library = new LatLng(16.04068814457871, 120.33095830646091);
        map.addMarker(new MarkerOptions().position(Dagupan_E_library).title("Dagupan E library"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Dagupan_E_library,9), 5000, null);

        LatLng Alcala_Library = new LatLng(15.84650939009416, 120.52185020460679);
        map.addMarker(new MarkerOptions().position(Alcala_Library).title("Alcala Library"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Alcala_Library,9), 5000, null);

        LatLng Dagupan_City_Public_Library_and_Information_Center = new LatLng(16.036513813587923, 120.3330496813272);
        map.addMarker(new MarkerOptions().position(Dagupan_City_Public_Library_and_Information_Center).title("Dagupan City Public Library and Information Center"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Dagupan_City_Public_Library_and_Information_Center,9), 5000, null);

        LatLng City_Library_Old_Urdaneta_Municipal_Hall = new LatLng(15.976218504519702, 120.56764479481882);
        map.addMarker(new MarkerOptions().position(City_Library_Old_Urdaneta_Municipal_Hall).title("City Library @ Old Urdaneta Municipal Hall"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(City_Library_Old_Urdaneta_Municipal_Hall,9), 5000, null);

        LatLng Binalonan_Municipal_Library = new LatLng(16.0456108844894, 120.5919314929685);
        map.addMarker(new MarkerOptions().position(Binalonan_Municipal_Library).title("Binalonan Municipal Library"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Binalonan_Municipal_Library,9), 5000, null);

        LatLng Binalonan_Municipal_Library_and_CEC = new LatLng(16.04624649473529, 120.59335110407582);
        map.addMarker(new MarkerOptions().position(Binalonan_Municipal_Library_and_CEC).title("Binalonan Municipal Library and CEC"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Binalonan_Municipal_Library_and_CEC,9), 5000, null);

        LatLng Sison_Municipal_Library = new LatLng(16.17325362266991, 120.51003477762673);
        map.addMarker(new MarkerOptions().position(Sison_Municipal_Library).title("Sison Municipal Library"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Sison_Municipal_Library,9), 5000, null);

        LatLng Don_Teofilo_Allas_Public_Library = new LatLng(16.027308971894982, 120.74529247451055);
        map.addMarker(new MarkerOptions().position(Don_Teofilo_Allas_Public_Library).title("Don Teofilo Allas Public Library"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Don_Teofilo_Allas_Public_Library,9), 5000, null);

        LatLng Bolosan_Barangay_Library = new LatLng(16.039996060432948, 120.3360496243396);
        map.addMarker(new MarkerOptions().position(Bolosan_Barangay_Library).title("Bolosan Barangay Library"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Bolosan_Barangay_Library,9), 5000, null);

        LatLng San_Fabian_Public_Library = new LatLng(16.120671565526663, 120.40244219667204);
        map.addMarker(new MarkerOptions().position(San_Fabian_Public_Library).title("San Fabian Public Library"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(San_Fabian_Public_Library,9), 5000, null);

        LatLng Binmaley_Public_Library = new LatLng(16.029050646835326, 120.26958317392236);
        map.addMarker(new MarkerOptions().position(Binmaley_Public_Library).title("Binmaley Public Library"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Binmaley_Public_Library,9), 5000, null);

        LatLng Herrero_Perez_Barangay_Library = new LatLng(16.043202581745078, 120.33242484450626);
        map.addMarker(new MarkerOptions().position(Herrero_Perez_Barangay_Library).title("Herrero-Perez Barangay Library"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Herrero_Perez_Barangay_Library,9), 5000, null);

        LatLng Labrador_Municipal_Library = new LatLng(15.997704231473865, 120.121908273897056);
        map.addMarker(new MarkerOptions().position(Labrador_Municipal_Library).title("Labrador Municipal Library"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Labrador_Municipal_Library,9), 5000, null);

        LatLng Pogo_Grande_Barangay_Library = new LatLng(16.035949534351488, 120.33289660646078);
        map.addMarker(new MarkerOptions().position(Pogo_Grande_Barangay_Library).title("Pogo-Grande Barangay Library"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Pogo_Grande_Barangay_Library,9), 5000, null);

        LatLng Municipal_Library_Bayambang_Pangasinan = new LatLng(15.810399002200379, 120.45692535804196);
        map.addMarker(new MarkerOptions().position(Municipal_Library_Bayambang_Pangasinan).title("Municipal Library @ Bayambang, Pangasinan"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Municipal_Library_Bayambang_Pangasinan,9), 5000, null);

        LatLng Mapandan_Municipal_Library = new LatLng(16.027283977927862, 120.45362684878883);
        map.addMarker(new MarkerOptions().position(Mapandan_Municipal_Library).title("Mapandan Municipal Library"));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(Mapandan_Municipal_Library,9), 5000, null);

    }
}