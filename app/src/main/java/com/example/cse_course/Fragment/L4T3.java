package com.example.cse_course.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cse_course.HomePage;
import com.example.cse_course.ModelClass;
import com.example.cse_course.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
public class L4T3 extends Fragment {
    ImageView imageView;
    GridView gridView;
    DatabaseReference databaseReference;
    private List<ModelClass> modelClassList;
    CustomAdapter customAdapter;
    ProgressDialog progressDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_l4_t3, container, false);
        imageView=view.findViewById(R.id.imageviewID);
        gridView= view.findViewById(R.id.GridView);
        progressDialog=new ProgressDialog(getActivity());

        databaseReference= FirebaseDatabase.getInstance().getReference("Course").child("L4T2");
        modelClassList=new ArrayList<>();
        customAdapter = new CustomAdapter(L4T3.this.getActivity(), modelClassList);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new  Intent(getActivity(), HomePage.class));
            }
        });
        return view;
    }
    @Override
    public void onStart() {
        progressDialog.setMessage("Fatching Course");
        progressDialog.show();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                modelClassList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    ModelClass modelClass=dataSnapshot.getValue(ModelClass.class);
                    modelClassList.add(modelClass);
                }
                gridView.setAdapter(customAdapter);
                customAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
    private class CustomAdapter extends ArrayAdapter<ModelClass> {
        private Context context;
        private List<ModelClass> modelClassList;

        public CustomAdapter(Context context, List<ModelClass> modelClassList) {
            super(context,R.layout.simple_row, modelClassList);
            this.context=context;
            this.modelClassList=modelClassList;
        }
        @NonNull
        @Override
        public View getView(int position,View convertView, ViewGroup parent) {
            LayoutInflater inflater=getActivity().getLayoutInflater();
            View view1=inflater.inflate(R.layout.simple_row,parent,false);

            ModelClass modelClass=modelClassList.get(position);

            TextView textView1=view1.findViewById(R.id.row1_ID);
            TextView textView2=view1.findViewById(R.id.row2_ID);

            textView1.setText(modelClass.getCourseCode());
            textView2.setText(modelClass.getCourseTitle());

            return view1;
        }
    }
}