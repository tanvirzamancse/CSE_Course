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
import android.widget.ListView;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_course_data);
        listView=findViewById(R.id.listID);
        list=new ArrayList<>();
        RetrivePDF();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PdfModel pdfModel = list.get(position);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(pdfModel.getFileUrl()));
                startActivity(intent);

//                Intent i = new Intent();
//                i.setAction(Intent.ACTION_VIEW);
//                i.putData(Uri.parse("www.example.com"))
//                context.startActivity(Intent.createChooser(i, "Share"));

            }
        });
    }

    private void RetrivePDF() {
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
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads){
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        TextView myText = (TextView) view.findViewById(android.R.id.text1);
                        myText.setTextColor(Color.RED);
                        return view;
                    }
                };
                listView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}