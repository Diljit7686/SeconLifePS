package com.example.seconlifeps.Fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.seconlifeps.R;
import com.example.seconlifeps.model.SQLiteHelper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


public class AddAppointFragment extends Fragment {

    public static SQLiteHelper mySqliteHelper;

    String userId;

    Button btnSave;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.addappo_fragment, container, false);
        
        btnSave = view.findViewById(R.id.appo_save);
        
        
        
        userId = "0";
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            userId = bundle.getString("userId", "0");
        }
        Log.d("Add Appo Fragment", userId.toString());


        btnSave.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //VALIDATIONS
                Log.d("Add Button","Clicked");



            }
            //NOT VALID
            // VALID
        });



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Log.d("OnViewCreated Event", "ok");

    }



}
