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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.seconlifeps.R;
import com.example.seconlifeps.model.Business;
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

    // Form controls
    TextView tvName,tvAddress,tvDays,tvHours,tvContact,tvMail,tvPrice;
    ImageView imageView;
    Button btnSave;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.addappo_fragment, container, false);

        imageView = view.findViewById(R.id.app_image);
        tvName    = view.findViewById(R.id.app_name);
        tvAddress = view.findViewById(R.id.app_address);
        tvDays    = view.findViewById(R.id.app_visit_days);
        tvHours   = view.findViewById(R.id.app_visit_hours);
        tvContact = view.findViewById(R.id.app_contact_number);
        tvMail    = view.findViewById(R.id.app_contact_email);
        tvPrice   = view.findViewById(R.id.app_price);
        btnSave = view.findViewById(R.id.app_btnSave);
        


        // bundle object to receive object
        Bundle arguments = getArguments();
        Business business; //= null;
        if (arguments != null)
        {
            business = (Business) arguments.getSerializable("objecto");
            // set data
            imageView.setImageResource(business.getBu_imagenId());
            tvName.setText(business.getBu_name());
            tvAddress.setText(business.getBu_address());
            tvDays.setText(business.getBu_visitDays());
//            tvHours.setText(business.getBu_visitHours());
            tvContact.setText(business.getBu_contactNo());
            tvMail.setText(business.getBu_email());
            tvPrice.setText(business.getBu_price());

        }


        Log.d("Add Appo Fragment", "userId");







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
