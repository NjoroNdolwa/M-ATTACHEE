package com.environment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.environment.m_attachee.R;
import com.environment.m_attachee.databinding.ActivityRegisterUserBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterUser extends AppCompatActivity {
    ActivityRegisterUserBinding binding;
    ProgressDialog pd;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        pd= new ProgressDialog(this);
        FirebaseDatabase firebaseDatabase;
        DatabaseReference databaseReference;
        pd.setTitle("Please Wait...");
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("attachee");
        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = binding.name.getText().toString().trim();
                String School = binding.school.getText().toString().trim();
                String Programme = binding.programme.getText().toString().trim();
                String Course = binding.course.getText().toString().trim();
                String ModuleYear = binding.module.getText().toString().trim();
                String Phone = binding.phone.getText().toString().trim();
                String Email = binding.email.getText().toString().trim();
                String Pass = binding.password.getText().toString().trim();
                String ConPass = binding.conpass.getText().toString().trim();
                String Y1 = "P";
                String Y2 = "P";
                String Y3 = "P";
                String Y4 = "P";
                String Y5= "A";
                if (Name.isEmpty()){
                    binding.name.setError("Required");
                    binding.name.requestFocus();
                }
                else if (Programme.isEmpty()){
                    binding.programme.setError("Required");
                    binding.programme.requestFocus();
                }
                else if (Course.isEmpty()){
                    binding.course.setError("Required");
                    binding.course.requestFocus();
                }
                else if (ModuleYear.isEmpty()){
                    binding.module.setError("Required");
                    binding.module.requestFocus();
                }
                else if (Phone.isEmpty()){
                    binding.school.setError("Required");
                    binding.school.requestFocus();
                }
                else if (School.isEmpty()){
                    binding.phone.setError("Required");
                    binding.phone.requestFocus();
                }
                else if (Email.isEmpty()){
                    binding.email.setError("Required");
                    binding.email.requestFocus();
                }
                else if (Pass.isEmpty()){
                    binding.password.setError("Required");
                    binding.password.requestFocus();
                }
                else if (ConPass.isEmpty()){
                    binding.conpass.setError("Required");
                    binding.conpass.requestFocus();
                }
                else {
                    pd.setMessage("Registering Your Details");
                    pd.show();
                    firebaseAuth.createUserWithEmailAndPassword(Email,Pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        insertData();
                                    }
                                }

                                private void insertData() {
                                    Map<String,Object> map = new HashMap<>();
                                    map.put("name",Name);
                                    map.put("school",School);
                                    map.put("programme",Programme);
                                    map.put("moduleYear",ModuleYear);
                                    map.put("course",Course);
                                    map.put("phone",Phone);
                                    map.put("email",Email);
                                    map.put("y1",Y1);
                                    map.put("y2",Y2);
                                    map.put("y3",Y3);
                                    map.put("y4",Y4);
                                    map.put("y5",Y5);
                                    pd.show();
                                    FirebaseDatabase.getInstance().getReference().child("attachee").push().setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Toast.makeText(getApplicationContext(), "Details Saved successfully", Toast.LENGTH_SHORT).show();
                                            pd.dismiss();
                                            startActivity(new Intent(getApplicationContext(),LoginUser.class));
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getApplicationContext(), "Error while Saving", Toast.LENGTH_SHORT).show();
                                            pd.dismiss();

                                        }
                                    });
                                };
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });


                }
            }

        });
    }
}