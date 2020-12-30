package com.example.cse_course.Fragment;

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


public class L1T2 extends Fragment {
//    final String[] Code={"CSE131","CSE133","CSE212","CSE221"};
//    final String[] Title={"Discrete Mathematics","Data Structures","Digital Logic","Theory Computing"};
    ImageView imageView;
    GridView gridView;
    DatabaseReference databaseReference;
    private List<ModelClass> modelClassList;
    CustomAdapter customAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_l1_t2, container, false);
        imageView=view.findViewById(R.id.imageviewID);
        gridView= view.findViewById(R.id.GridView);
        databaseReference= FirebaseDatabase.getInstance().getReference("Course").child("L1T2");
        modelClassList=new ArrayList<>();
        customAdapter = new CustomAdapter(L1T2.this.getActivity(), modelClassList);

//        CustomAdapter customAdapter=new CustomAdapter();
//        gridView.setAdapter(customAdapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HomePage.class));
            }
        });
        return view;
    }


    @Override
    public void onStart() {
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
//    private class CustomAdapter  extends BaseAdapter {
//        @Override
//        public int getCount() {
//            return Code.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            View view1= getLayoutInflater().inflate(R.layout.simple_row,null);
//            TextView textView1=view1.findViewById(R.id.row1_ID);
//            TextView textView2=view1.findViewById(R.id.row2_ID);
//            textView1.setText(Code[position]);
//            textView2.setText(Title[position]);
//            return view1;
//        }
//    }


}