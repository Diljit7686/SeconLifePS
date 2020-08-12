package com.example.seconlifeps.Fragments;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seconlifeps.R;
import com.example.seconlifeps.adapters.Adapter_appointments;
import com.example.seconlifeps.adapters.Adapter_shelters;
import com.example.seconlifeps.interfaces.iShelters;
import com.example.seconlifeps.model.Appointments;
import com.example.seconlifeps.model.Business;
import com.example.seconlifeps.model.SQLiteHelper;

import java.util.ArrayList;

public class AppointmentsFragment extends Fragment{

    public static SQLiteHelper mySqliteHelper;

    String userId;
    Double userlat,userlong;

    Adapter_appointments adapter_appointments;
    RecyclerView recyclerView;

    ArrayList<Appointments> business_list;

    //reference to Reviews Fragment
    Activity activity;
    iShelters ishelters;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view    = inflater.inflate(R.layout.appointments_fragment,container,false);

        userId = "0";
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            userId = bundle.getString("userId", "0");
        }
        Log.d("Shelters Fragment", userId);

        // Getting last location from User
        mySqliteHelper = new SQLiteHelper(this.getContext(),"RECORDDB1.sqlite",null,1);

        String sqlstr = "SELECT us_id,us_email, us_firstName, us_lastName, us_latitude, us_longitude " +
                "FROM User WHERE us_id = " + userId;
        Cursor cursor = mySqliteHelper.getData(sqlstr);

        int c = cursor.getCount();
        if (c == 0)
        {
            Log.d("User:","NOT FOUND");
            System.out.println("Users: "+c);
            Toast.makeText(getActivity(),"No User found", Toast.LENGTH_SHORT).show();
            // show error ;
        }
        // Valid
        else
        {
            Log.d("User:","FOUND");
            System.out.println("Users: "+c);
        }
        while(cursor.moveToNext())
        {
            int id       = cursor.getInt(0);
            String email = cursor.getString(1);
            String fname  = cursor.getString(2);
            String lname  = cursor.getString(3);
            String lat  = cursor.getString(4);
            String lon  = cursor.getString(5);
            Log.d("User:",email);
            Log.d("Last location:",lat+","+lon);
            userlat = Double.parseDouble(lat);
            userlong= Double.parseDouble(lon);
        }


        recyclerView = view.findViewById(R.id.recyclerViewAppointments);   //layout name in shelters_fragment.xml

        business_list = new ArrayList<>();


        // Fetch all appointments available from db.   (dymanic version - 2 phase)
        /*
        sqlstr = "SELECT bu_id, bu_name, bu_address, bu_visitDays, bu_visitHours, bu_contactNo, bu_email, bu_price, bu_imagenId, bu_lat, bu_lon " +
                "FROM Business c, User b, Appointments a";   //  WHERE bu_id = " + businessId;
        cursor = mySqliteHelper.getData(sqlstr);

        c = cursor.getCount();
        if (c == 0)
        {
            Log.d("Businesses:","NOT FOUND");
            Toast.makeText(getActivity(),"No shelters found nearby", Toast.LENGTH_SHORT).show();
            // show error ;
        }
        // Valid
        else
        {
            System.out.println("Business found: "+c);
        }
        while(cursor.moveToNext())
        {
            int id        = cursor.getInt(0);
            String bname  = cursor.getString(1);
            String baddr  = cursor.getString(2);
            String bdays  = cursor.getString(3);
            String bhours = cursor.getString(4);
            String bno    = cursor.getString(5);
            String bemail = cursor.getString(6);
            String bprice = cursor.getString(7);
            byte[] image = cursor.getBlob(8);
            Double blat   = cursor.getDouble(9);
            Double blon   = cursor.getDouble(10);
            Log.d("Business:",bname);

            business_list.add(new Business(id,bname,baddr,bdays,bhours,bno,bemail,bprice,image,blat,blon));


        }

*/


       // Appointments(Integer ap_id, Integer bu_id, Integer us_id, String ap_date, String ap_hour) {
        //------------
        // Creating the list of appointment (static version)
        business_list.add(new Appointments(1,1,1,"08/10/2020","9:00"));
        business_list.add(new Appointments(2,1,1,"07/30/2020","9:00"));



        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));    //cos it's a fragment

        adapter_appointments  = new Adapter_appointments(getContext(),business_list);

        recyclerView.setAdapter(adapter_appointments);

        adapter_appointments.notifyDataSetChanged();

        adapter_appointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = business_list.get(recyclerView.getChildAdapterPosition(view)).getAp_date();
                Toast.makeText(getContext(),"selected " + address,Toast.LENGTH_LONG).show();

                //interface envia objecto
              //  ishelters.sendShelter(business_list.get(recyclerView.getChildAdapterPosition(view)));  //send all object
              //  ishelters.sendShelter(busines_nearby.get(recyclerView.getChildAdapterPosition(view))); //send the object
            }
        });

        System.out.println(business_list.size());


        return view;
    }

    public void loadData() {


    }

    public void showData() {

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
