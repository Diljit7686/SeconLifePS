package com.example.seconlifeps.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.seconlifeps.R;
import com.example.seconlifeps.model.Business;
import com.example.seconlifeps.model.SQLiteHelper;


public class AddReviewFragment extends Fragment {

    public static SQLiteHelper mySqliteHelper;

    String userId;

    // Form controls
    TextView tvName,tvAddress,tvDays,tvHours,tvContact,tvMail,tvPrice;
    ImageView imageView;
    Button btnSave;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.addreview_fragment, container, false);

        imageView = view.findViewById(R.id.rv_image);
        tvName    = view.findViewById(R.id.rv_name);
        tvAddress = view.findViewById(R.id.rv_address);
        tvDays    = view.findViewById(R.id.rv_visit_days);
        tvHours   = view.findViewById(R.id.rv_visit_hours);
        tvContact = view.findViewById(R.id.rv_contact_number);
        tvMail    = view.findViewById(R.id.rv_contact_email);
        tvPrice   = view.findViewById(R.id.rv_price);
        btnSave = view.findViewById(R.id.rv_btnSave);
        


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
