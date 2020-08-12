package com.example.seconlifeps.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seconlifeps.R;
import com.example.seconlifeps.model.Appointments;
import com.example.seconlifeps.model.Business;

import java.util.ArrayList;

//import android.R.layout;

public class Adapter_appointments extends RecyclerView.Adapter<Adapter_appointments.ViewHolder> implements View.OnClickListener{

    ArrayList<Appointments> model;

    LayoutInflater inflater;

    //Listener
    private View.OnClickListener listener;


    public Adapter_appointments(Context context, ArrayList<Appointments> lista) {

        this.inflater = LayoutInflater.from(context);
        this.model    =  lista;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shelters_list,parent,false);
        View view = inflater.inflate(R.layout.appointment_list,parent,false);

        view.setOnClickListener(this);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String adress = "67 Six Point Rd, Etobicoke, ON M8Z";  //model.get(position).getBu_address();
        String days    = model.get(position).getAp_date();
        String hours   = model.get(position).getAp_hour();

       // int img  = model.get(position).getBu_imagenId();

        holder.address.setText(adress);
        holder.visitDays.setText(days);
        holder.visitHours.setText(hours);

      //  holder.img.setImageResource(img);


    }

    @Override
    public int getItemCount() {
        return model.size();
    }


    @Override
    public void onClick(View view) {

        if (listener != null)
        {
            listener.onClick(view);
        }
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;


    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView address, visitDays, visitHours;
       // ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            address = itemView.findViewById(R.id.apps_address);
            visitDays = itemView.findViewById(R.id.apps_date);
            visitHours = itemView.findViewById(R.id.apps_hour);

         //   img = itemView.findViewById(R.id.image_shelter);


        }
    }


}
