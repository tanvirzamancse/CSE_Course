package com.example.cse_course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.cse_course.Fragment.L1T1;
import com.example.cse_course.Fragment.L1T2;
import com.example.cse_course.Fragment.L1T3;
import com.example.cse_course.Fragment.L2T1;
import com.example.cse_course.Fragment.L2T2;
import com.example.cse_course.Fragment.L2T3;
import com.example.cse_course.Fragment.L3T1;
import com.example.cse_course.Fragment.L3T2;
import com.example.cse_course.Fragment.L3T3;
import com.example.cse_course.Fragment.L4T1;
import com.example.cse_course.Fragment.L4T2;
import com.example.cse_course.Fragment.L4T3;

import static java.security.AccessController.getContext;

public class MainActivity2 extends AppCompatActivity {
//    int position;
//    FragmentManager fm = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent=getIntent();
        int position =intent.getIntExtra("position",0);
//        FragmentTransaction ft = fm.beginTransaction();
//        L1T1 l1T1 = new L1T1();
//        ft.replace(R.id.fragmentContainer,l1T1);
//        ft.addToBackStack(null);
//        ft.commit();
     if (position==0){
            L1T1 l1T1=new L1T1();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,l1T1).addToBackStack(null).commit();
        }
     if (position==1){
            L1T2 l1T2=new L1T2();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,l1T2).addToBackStack(null).commit();
        }
        if (position==2){
            L1T3 l1T3=new L1T3();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,l1T3).addToBackStack(null).commit();
        }
        if (position==3){
            L2T1 l2T1=new L2T1();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,l2T1).addToBackStack(null).commit();
        }
        if (position==4){
            L2T2 l2T2=new L2T2();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,l2T2).addToBackStack(null).commit();
        }
        if (position==5){
            L2T3 l2T3=new L2T3();
           getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,l2T3).addToBackStack(null).commit();
        }
        if (position==6){
            L3T1 l3T1=new L3T1();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,l3T1).addToBackStack(null).commit();
        }
        if (position==7){
            L3T2 l3T2=new L3T2();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,l3T2).addToBackStack(null).commit();
        }
        if (position==8){
            L3T3 l3T3=new L3T3();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,l3T3).addToBackStack(null).commit();
        }
        if (position==9){
            L4T1 l4T1=new L4T1();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,l4T1).addToBackStack(null).commit();
        }
        if (position==10){
            L4T2 l4T2=new L4T2();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,l4T2).addToBackStack(null).commit();
        }
        if (position==11){
            L4T3 l4T3=new L4T3();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,l4T3).addToBackStack(null).commit();
        }

    }
}