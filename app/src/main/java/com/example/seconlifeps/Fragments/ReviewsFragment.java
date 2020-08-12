package com.example.seconlifeps.Fragments;
import android.app.Activity;
import android.content.Context;
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
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seconlifeps.R;
import com.example.seconlifeps.adapters.Adapter_reviews;
import com.example.seconlifeps.adapters.Adapter_shelters;
import com.example.seconlifeps.interfaces.iShelters;
import com.example.seconlifeps.model.Business;
import com.example.seconlifeps.model.Reviews;

import java.util.ArrayList;

public class ReviewsFragment extends Fragment{

    // Form controls
    TextView tvName,tvAddress,tvDays,tvHours,tvContact,tvMail,tvPrice;
    ImageView imageView;
    Button btnAppointment, btnReview;

    //Reference to AddAppointment Fragment
    Activity activity;
    iShelters ishelters;
    Business business; //= null;

    //RecyclerView variables
    Adapter_reviews adapter_reviews;
    RecyclerView recyclerView;

    //Content of RecyclerView
    ArrayList<Reviews> review_list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.reviews_fragment,container,false);

        imageView = view.findViewById(R.id.det_image);
        tvName    = view.findViewById(R.id.det_name);
        tvAddress = view.findViewById(R.id.det_address);
        tvDays    = view.findViewById(R.id.det_visit_days);
       // tvHours   = view.findViewById(R.id.det_hourApp);
        tvContact = view.findViewById(R.id.det_contact_number);
        tvMail    = view.findViewById(R.id.det_contact_email);
        tvPrice   = view.findViewById(R.id.det_price);

        btnReview = view.findViewById(R.id.det_btnRev);
        btnAppointment = view.findViewById(R.id.det_btnApp);



        // bundle object to receive object
        Bundle objectShelter = getArguments();


        if (objectShelter != null)
        {
            business = (Business) objectShelter.getSerializable("objecto");
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

        Log.d("Reviews Fragment", "userId");

        recyclerView = view.findViewById(R.id.recyclerViewReviews);

        review_list = new ArrayList<>();

        review_list.add(new Reviews(1,1,1,"07/30/2020","I'd like to receive the lastest news, updates " +
                "and promotions, special offers and exclusive savings."));
        review_list.add(new Reviews(2,1,2,"05/11/2020","The largest animal shelter of Toronto and takes in over " +
                "3,500 animals every year. Please open your heart and your home for a ready pet."));
        review_list.add(new Reviews(3,1,2,"01/10/2020","I've have fostered for and they provided me " +
                "with everything I need. they vetted the baby and I eventually foster failed."));
        review_list.add(new Reviews(4,1,1,"07/23/2020","I'd like to receive the lastest news, updates " +
                "and promotions, special offers and exclusive savings."));
        review_list.add(new Reviews(5,1,2,"05/11/2020","The largest animal shelter of Toronto and takes in over " +
                "3,500 animals every year. Please open your heart and your home for a ready pet."));
        review_list.add(new Reviews(6,1,2,"01/10/2020","I've have fostered for and they provided me " +
                "with everything I need. they vetted the baby and I eventually foster failed."));


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter_reviews = new Adapter_reviews(getContext(),review_list);

        recyclerView.setAdapter(adapter_reviews);

        adapter_reviews.notifyDataSetChanged();

        btnAppointment.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //VALIDATIONS
              Log.d("Add Appoint","Clicked");


                //NOT VALID
                // VALID


               /* crear otro metodo en la interface
                iShelters.sendAppointment( objeto deseado , ??? busined id y user id o los objetos shelters,user,reviews
                 ;a interface podria hacer tod-o  en el MainActivity, no  solo pasar parametros y abrir otro fragment;
                 si no podira grabar en la base de datos o recuperar datos de la base.

                 la aplicacion de image o location (activiy ) podria ver lamaner de swticear entre activity.
                 o usar interfaces para eso..

                */


                // get the business id from bundle dcreating a business property in the fragment
                ishelters.sendToAppointment(business);
                //send the object




            }

        });

        btnReview.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //VALIDATIONS
                Log.d("Add Review","Clicked");


                //NOT VALID
                // VALID


               /* crear otro metodo en la interface
                iShelters.sendAppointment( objeto deseado , ??? busined id y user id o los objetos shelters,user,reviews
                 ;a interface podria hacer tod-o  en el MainActivity, no  solo pasar parametros y abrir otro fragment;
                 si no podira grabar en la base de datos o recuperar datos de la base.

                 la aplicacion de image o location (activiy ) podria ver lamaner de swticear entre activity.
                 o usar interfaces para eso..

                */


                // get the business id from bundle dcreating a business property in the fragment
                ishelters.sendToReview(business);
                //send the object

/*una unterface que use on objeto mas global que represente la sesion o estado de la app.

                        SESion o ESTado
                        -id

                        -user
                        -business

*/

            }

        });




        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof Activity) {
            this.activity = (Activity) context;
            ishelters     = (iShelters) this.activity;


        }
    }
}

