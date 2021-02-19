package com.example.cse_course;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.cse_course.Fragment.L1T1;
import com.example.cse_course.Fragment.L1T2;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class ShowCourseData extends AppCompatActivity {
    ListView listView;
    DatabaseReference databaseReference;
    List<PdfModel> list;
    private DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_course_data);
        listView=findViewById(R.id.listID);
        list=new ArrayList<>();
         dataAdapter= new DataAdapter(ShowCourseData.this,list);


        Intent intent=getIntent();
        int position =intent.getIntExtra("position",0);

        if (position==0){
            RetrivePDF0();

        }
        if (position==1){
            RetrivePDF1();

        }
        if (position==2){
            RetrivePDF2();

        }
        if (position==3){
            RetrivePDF3();

        }
        if (position==4){
            RetrivePDF4();

        }
        if (position==5){
            RetrivePDF5();

        }

        

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PdfModel pdfModel = list.get(position);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(pdfModel.getFileUrl()));
                startActivity(intent);
            }
        });
    }

    private void RetrivePDF0() {
        databaseReference= FirebaseDatabase.getInstance().getReference().child("CourseMaterial").child("L1T1").child("CSE112");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    PdfModel pdfModel = postSnapshot.getValue(PdfModel.class);
                    list.add(pdfModel);
                }
                String[] uploads = new String[list.size()];
                for (int i=0; i < uploads.length; i++){
                    uploads[i] = list.get(i).getFileName();
                }
                 dataAdapter= new DataAdapter(ShowCourseData.this,list);
                 listView.setAdapter(dataAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void RetrivePDF1() {
        databaseReference= FirebaseDatabase.getInstance().getReference().child("CourseMaterial").child("L1T1").child("MAT111");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    PdfModel pdfModel = postSnapshot.getValue(PdfModel.class);
                    list.add(pdfModel);
                }
                String[] uploads = new String[list.size()];
                for (int i=0; i < uploads.length; i++){
                    uploads[i] = list.get(i).getFileName();
                }

                dataAdapter= new DataAdapter(ShowCourseData.this,list);
                listView.setAdapter(dataAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    private void RetrivePDF2() {
        databaseReference= FirebaseDatabase.getInstance().getReference().child("CourseMaterial").child("L1T1").child("ENG113");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    PdfModel pdfModel = postSnapshot.getValue(PdfModel.class);
                    list.add(pdfModel);
                }
                String[] uploads = new String[list.size()];
                for (int i=0; i < uploads.length; i++){
                    uploads[i] = list.get(i).getFileName();
                }

                dataAdapter= new DataAdapter(ShowCourseData.this,list);
                listView.setAdapter(dataAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    private void RetrivePDF3() {
        databaseReference= FirebaseDatabase.getInstance().getReference().child("CourseMaterial").child("L1T1").child("PHY113");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    PdfModel pdfModel = postSnapshot.getValue(PdfModel.class);
                    list.add(pdfModel);
                }
                String[] uploads = new String[list.size()];
                for (int i=0; i < uploads.length; i++){
                    uploads[i] = list.get(i).getFileName();
                }

                dataAdapter= new DataAdapter(ShowCourseData.this,list);
                listView.setAdapter(dataAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    private void RetrivePDF4() {
        databaseReference= FirebaseDatabase.getInstance().getReference().child("CourseMaterial").child("L1T1").child("PHY114");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    PdfModel pdfModel = postSnapshot.getValue(PdfModel.class);
                    list.add(pdfModel);
                }
                String[] uploads = new String[list.size()];
                for (int i=0; i < uploads.length; i++){
                    uploads[i] = list.get(i).getFileName();
                }

                dataAdapter= new DataAdapter(ShowCourseData.this,list);
                listView.setAdapter(dataAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    private void RetrivePDF5() {
        databaseReference= FirebaseDatabase.getInstance().getReference().child("CourseMaterial").child("L1T1").child("GED111");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    PdfModel pdfModel = postSnapshot.getValue(PdfModel.class);
                    list.add(pdfModel);
                }
                String[] uploads = new String[list.size()];
                for (int i=0; i < uploads.length; i++){
                    uploads[i] = list.get(i).getFileName();
                }

                dataAdapter= new DataAdapter(ShowCourseData.this,list);
                listView.setAdapter(dataAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }




    public void Back(View view) {
        onBackPressed();
    }
}