package com.environment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.environment.m_attachee.R;

import java.util.ArrayList;

public class AttacheesAdapter extends RecyclerView.Adapter<AttacheesAdapter.MyViewHolder> {
    Context context;
    ArrayList<UserClass> userClassArrayList;

    public AttacheesAdapter(Context context, ArrayList<UserClass> userClassArrayList) {
        this.context = context;
        this.userClassArrayList = userClassArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.all_attachees,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UserClass userClass = userClassArrayList.get(position);
        holder.name.setText(userClass.getName());
        holder.school.setText(userClass.getSchool());
        holder.programme.setText(userClass.getProgramme());
        holder.moduleYear.setText(userClass.getModuleYear());
        holder.phone.setText(userClass.getPhone());
        holder.course.setText(userClass.getCourse());
        holder.y1.setText(userClass.getY1());
        holder.y2.setText(userClass.getY2());
        holder.y3.setText(userClass.getY3());
        holder.y4.setText(userClass.getY4());
        holder.y5.setText(userClass.getY5());

    }

    @Override
    public int getItemCount() {
        return userClassArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, course,school,moduleYear, phone, programme,email,y1,y2,y3,y4,y5;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            course = itemView.findViewById(R.id.course);
            school = itemView.findViewById(R.id.school);
            moduleYear= itemView.findViewById(R.id.moduleYear);
            phone = itemView.findViewById(R.id.phone);
            programme = itemView.findViewById(R.id.programme);
            y1=itemView.findViewById(R.id.y1);
            y2=itemView.findViewById(R.id.y2);
            y3=itemView.findViewById(R.id.y3);
            y4=itemView.findViewById(R.id.y4);
            y5=itemView.findViewById(R.id.y5);
        }
    }
}
