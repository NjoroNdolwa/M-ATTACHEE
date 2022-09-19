//package com.environment;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.environment.m_attachee.R;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.database.FirebaseDatabase;
//import com.orhanobut.dialogplus.DialogPlus;
//import com.orhanobut.dialogplus.ViewHolder;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
//    Context context;
//    ArrayList<UserClass> userClassArrayList;
//
//    public MyAdapter(Context context, ArrayList<UserClass> userClassArrayList) {
//        this.context = context;
//        this.userClassArrayList = userClassArrayList;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View v = LayoutInflater.from(context).inflate(R.layout.admin_attachee,parent,false);
//        return new MyViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        UserClass userClass = userClassArrayList.get(position);
//        holder.name.setText(userClass.getName());
//        holder.school.setText(userClass.getSchool());
//        holder.programme.setText(userClass.getProgramme());
//        holder.moduleYear.setText(userClass.getModuleYear());
//        holder.phone.setText(userClass.getPhone());
//        holder.course.setText(userClass.getCourse());
//        holder.y1.setText(userClass.getY1());
//        holder.y2.setText(userClass.getY2());
//        holder.y3.setText(userClass.getY3());
//        holder.y4.setText(userClass.getY4());
//        holder.y5.setText(userClass.getY5());
//        holder.edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.phone.getContext())
//                        .setContentHolder(new ViewHolder(R.layout.update))
//                        .setExpanded(true,1000)
//                        .create();
//                dialogPlus.show();
//                View view1 = dialogPlus.getHolderView();
//                TextView name = view1.findViewById(R.id.name);
//                TextView school = view1.findViewById(R.id.school);
//                TextView programme = view1.findViewById(R.id.programme);
//                TextView moduleYear = view1.findViewById(R.id.moduleYear);
//                TextView phone = view1.findViewById(R.id.phone);
//                TextView course = view1.findViewById(R.id.course);
//                TextView y1 = view1.findViewById(R.id.y1);
//                TextView y2 = view1.findViewById(R.id.y2);
//                TextView y3 = view1.findViewById(R.id.y3);
//                TextView y4 = view1.findViewById(R.id.y4);
//                TextView y5 = view1.findViewById(R.id.y5);
//
//                Button update = view.findViewById(R.id.update);
//                name.setText(userClass.getName());
//                school.setText(userClass.getSchool());
//                programme.setText(userClass.getProgramme());
//                moduleYear.setText(userClass.getModuleYear());
//                phone.setText(userClass.getPhone());
//                course.setText(userClass.getCourse());
//                y1.setText(userClass.getY1());
//                y2.setText(userClass.getY2());
//                y3.setText(userClass.getY3());
//                y4.setText(userClass.getY4());
//                y5.setText(userClass.getY5());
//                dialogPlus.show();
//                update.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Map<String,Object> map = new HashMap<>();
//                        map.put("name",name.getText().toString());
//                        map.put("school",school.getText().toString());
//                        map.put("programme",programme.getText().toString());
//                        map.put("moduleYear",moduleYear.getText().toString());
//                        map.put("course",course.getText().toString());
//                        map.put("phone",phone.getText().toString());
//                        map.put("y1",y1.getText().toString());
//                        map.put("y2",y2.getText().toString());
//                        map.put("y3",y3.getText().toString());
//                        map.put("y4",y3.getText().toString());
//                        map.put("y5",y5.getText().toString());
//
//                        FirebaseDatabase.getInstance().getReference().child("Tenants")
//                                .child(getRef(position).getKey()).updateChildren(map)
//                                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                    @Override
//                                    public void onSuccess(Void unused) {
//                                        Toast.makeText(holder.name.getContext(), "Data updated successfully", Toast.LENGTH_SHORT).show();
//                                        dialogPlus.dismiss();
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure( Exception e) {
//                                        Toast.makeText(holder.name.getContext(), "Error while updating", Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//                    }
//                });
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return userClassArrayList.size();
//    }
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder{
//        TextView name, course,school,moduleYear, phone, programme,email,y1,y2,y3,y4,y5,edit;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            name = itemView.findViewById(R.id.name);
//            course = itemView.findViewById(R.id.course);
//            school = itemView.findViewById(R.id.school);
//            moduleYear= itemView.findViewById(R.id.moduleYear);
//            phone = itemView.findViewById(R.id.phone);
//            programme = itemView.findViewById(R.id.programme);
//            y1=itemView.findViewById(R.id.y1);
//            y2=itemView.findViewById(R.id.y2);
//            y3=itemView.findViewById(R.id.y3);
//            y4=itemView.findViewById(R.id.y4);
//            y5=itemView.findViewById(R.id.y5);
//            edit=itemView.findViewById(R.id.edit);
//        }
//    }
//
//}
