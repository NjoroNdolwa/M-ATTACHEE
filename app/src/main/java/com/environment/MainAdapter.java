package com.environment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.environment.m_attachee.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter<UserClass,MainAdapter.myViewHolder> {
    Context context;
    ArrayList<UserClass> userClassArrayList;


    private int position;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<UserClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull UserClass userClass) {
        this.position = position;
       // UserClass userClass = userClassArrayList.get(position);
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

        /*Glide.with(holder.img.getContext())
                .load(model.getUrl())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.house_room)
                .into(holder.img);
*/
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.name.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update))
                        .setExpanded(true,1000)
                        .create();
                dialogPlus.show();

                View view1 = dialogPlus.getHolderView();
                EditText name = view1.findViewById(R.id.name);
                EditText school = view1.findViewById(R.id.school);
                EditText programme = view1.findViewById(R.id.programme);
                EditText moduleYear = view1.findViewById(R.id.moduleYear);
                EditText phone = view1.findViewById(R.id.phone);
                EditText course = view1.findViewById(R.id.course);
                EditText y1 = view1.findViewById(R.id.y1);
                EditText y2 = view1.findViewById(R.id.y2);
                EditText y3 = view1.findViewById(R.id.y3);
                EditText y4 = view1.findViewById(R.id.y4);
                EditText y5 = view1.findViewById(R.id.y5);

                Button update = view1.findViewById(R.id.update);
                name.setText(userClass.getName());
                school.setText(userClass.getSchool());
                programme.setText(userClass.getProgramme());
                moduleYear.setText(userClass.getModuleYear());
                phone.setText(userClass.getPhone());
                course.setText(userClass.getCourse());
                y1.setText(userClass.getY1());
                y2.setText(userClass.getY2());
                y3.setText(userClass.getY3());
                y4.setText(userClass.getY4());
                y5.setText(userClass.getY5());
                dialogPlus.show();

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("name",name.getText().toString());
                        map.put("school",school.getText().toString());
                        map.put("programme",programme.getText().toString());
                        map.put("moduleYear",moduleYear.getText().toString());
                        map.put("course",course.getText().toString());
                        map.put("phone",phone.getText().toString());
                        map.put("y1",y1.getText().toString());
                        map.put("y2",y2.getText().toString());
                        map.put("y3",y3.getText().toString());
                        map.put("y4",y3.getText().toString());
                        map.put("y5",y5.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("attachee")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.name.getContext(), "Data updated successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure( Exception e) {
                                        Toast.makeText(holder.name.getContext(), "Error while updating", Toast.LENGTH_SHORT).show();
                                    }
                                });

                    }
                });
            }
        });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_attachee,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView name, course,school,moduleYear, phone, programme,email,y1,y2,y3,y4,y5,edit;


        public myViewHolder(@NonNull View itemView) {
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
            edit=itemView.findViewById(R.id.edit);
        }
    }
}

