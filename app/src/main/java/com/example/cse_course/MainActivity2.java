package com.example.cse_course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.cse_course.Fragment.L1T1;
import com.example.cse_course.Fragment.L1T2;

import static java.security.AccessController.getContext;

public class MainActivity2 extends AppCompatActivity {
    int position;
    FragmentManager fm = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        FragmentTransaction ft = fm.beginTransaction();
        L1T1 l1T1 = new L1T1();
        ft.replace(R.id.fragmentContainer,l1T1);
        ft.addToBackStack(null);
        ft.commit();


//        if (position==0){
//            Intent intent=getIntent();
//            String a = String.valueOf(position);
//            L1T1 l1T1=new L1T1();
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,l1T1).addToBackStack(null).commit();
//        }

        

       



    }
}