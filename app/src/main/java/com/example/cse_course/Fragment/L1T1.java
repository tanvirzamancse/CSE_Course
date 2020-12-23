package com.example.cse_course.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cse_course.HomePage;
import com.example.cse_course.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class L1T1 extends Fragment{
    final String[] Code={"CSE131","CSE133","CSE212","CSE221"};
    final String[] Title={"Discrete Mathematics","Data Structures","Digital Logic","Theory Computing"};
    ImageView imageView;
    GridView gridView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_l1_t1, container, false);
       // ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView=view.findViewById(R.id.imageviewID);

        gridView= view.findViewById(R.id.GridView);
        CustomAdapter customAdapter=new CustomAdapter();
        gridView.setAdapter(customAdapter);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new  Intent(getActivity(), HomePage.class));
            }
        });


        return view;

    }

    private class CustomAdapter  extends BaseAdapter {
        @Override
        public int getCount() {
            return Code.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1= getLayoutInflater().inflate(R.layout.simple_row,null);
            TextView textView1=view1.findViewById(R.id.row1_ID);
            TextView textView2=view1.findViewById(R.id.row2_ID);
            textView1.setText(Code[position]);
            textView2.setText(Title[position]);
            return view1;
        }
    }


//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId()== android.R.id.home) {
//            getActivity().finish();
//        }
//        return super.onOptionsItemSelected(item);
//    }
}