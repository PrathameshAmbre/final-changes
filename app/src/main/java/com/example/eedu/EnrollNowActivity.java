package com.example.eedu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eedu.CourseListDatabase.courseData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EnrollNowActivity extends AppCompatActivity {
    Button btn_enroll;
    String cName,cDescription;
    DatabaseReference databaseReference;
    TextView courseName,courseDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_now);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        courseName=findViewById(R.id.course_name);
        courseDescription=findViewById(R.id.course_description);

        getIncoming();
        LoadData();

        btn_enroll=findViewById(R.id.enroll_now_btn);
        btn_enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EnrollNowActivity.this,CoursePageActivity.class);
                intent.putExtra("name",cName);
                startActivity(intent);
            }
        });

        courseName.setText(cName);
        courseDescription.setText(cDescription);
    }
    public void getIncoming(){
        if (getIntent().hasExtra("name") && getIntent().hasExtra("description")){
            cName=getIntent().getStringExtra("name");
            cDescription=getIntent().getStringExtra("description");
        }

    }

    public void LoadData(){

//        databaseReference=FirebaseDatabase.getInstance().getReference("Courses").child(cName);
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                    String name=snapshot.child("name").getValue().toString();
//                    String description=snapshot.child("description").getValue().toString();
//
//                    courseName.setText(name);
//                    courseDescription.setText(description);
//
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

    }
}