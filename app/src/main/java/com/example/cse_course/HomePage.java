package com.example.cse_course;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

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
import com.google.android.material.navigation.NavigationView;
public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private GridView gridView;
    private String[] Semister;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        gridView=findViewById(R.id.gridID);

        drawerLayout=findViewById(R.id.drawerId);
        navigationView=findViewById(R.id.navigationViewID);
        navigationView.setNavigationItemSelectedListener(this);
        Toolbar toolbar=findViewById(R.id.toolberID);
        setSupportActionBar(toolbar);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        Semister=getResources().getStringArray(R.array.semister);
        GridAdapter gridAdapter=new GridAdapter();
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(HomePage.this,MainActivity2.class);
                intent.putExtra("position",position);
                startActivity(intent);

//                if (position==0){
//                    Intent intent=new Intent(HomePage.this,MainActivity2.class);
//                    intent.putExtra("position",position);
//                    startActivity(intent);
//                }
//                if (position==1){
//                    Intent intent=new Intent(HomePage.this,MainActivity2.class);
//                    intent.putExtra("position",position);
//                    startActivity(intent);
//                }
//                if (position==2){
//                    Intent intent=new Intent(HomePage.this,MainActivity2.class);
//                    intent.putExtra("position",position);
//                    startActivity(intent);
//                }
//                if (position==3){
//                    Intent intent=new Intent(HomePage.this,MainActivity2.class);
//                    intent.putExtra("position",position);
//                    startActivity(intent);
//                }
//                if (position==4){
//                    Intent intent=new Intent(HomePage.this,MainActivity2.class);
//                    intent.putExtra("position",position);
//                    startActivity(intent);
//                }
//                if (position==5){
//                    Intent intent=new Intent(HomePage.this,MainActivity2.class);
//                    intent.putExtra("position",position);
//                    startActivity(intent);
////                    AppCompatActivity activity=(AppCompatActivity)view.getContext();
////                    L2T3 l2T3=new L2T3();
////                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.drawerId,l2T3).addToBackStack(null).commit();
//                }
//                if (position==6){
//                    Intent intent=new Intent(HomePage.this,MainActivity2.class);
//                    intent.putExtra("position",position);
//                    startActivity(intent);
//                }
//                if (position==7){
//                    Intent intent=new Intent(HomePage.this,MainActivity2.class);
//                    intent.putExtra("position",position);
//                    startActivity(intent);
//                }
//                if (position==8){
//                    Intent intent=new Intent(HomePage.this,MainActivity2.class);
//                    intent.putExtra("position",position);
//                    startActivity(intent);
//                }
//                if (position==9){
//                    Intent intent=new Intent(HomePage.this,MainActivity2.class);
//                    intent.putExtra("position",position);
//                    startActivity(intent);
//                }
//                if (position==10){
//                    Intent intent=new Intent(HomePage.this,MainActivity2.class);
//                    intent.putExtra("position",position);
//                    startActivity(intent);
//                }
//                if (position==11){
//                    Intent intent=new Intent(HomePage.this,MainActivity2.class);
//                    intent.putExtra("position",position);
//                    startActivity(intent);
//
//                }

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
    switch (id){
        case R.id.Home:
            Toast.makeText(this, "Home", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(getApplicationContext(),HomePage.class);
            startActivity(intent);
            break;
        case R.id.About:
            Toast.makeText(this, "ClassUp helps students(university, college, school)" +
                    " manage classes, organize notes, track tasks, and communicate with classmates." +
                    " - Easily manage classes(courses, lesson, lectures) by searching for and" +
                    " adding classes entered by other users.", Toast.LENGTH_LONG).show();
            break;
        case R.id.Contact:
            Toast.makeText(this, "Name: Md.Musaddikul islam Mishon\n" +
                    "Id: 171-15-9127\n" +
                    "Email: musaddikul15-9127@diu.edu.bd\n" +
                    "Phone: 01842020064\n" +
                    "Name: Md.Juavaraj Nilay\n" +
                    "Id: 171-15-8967\n" +
                    "Email: juvaraj15-8967@diu.edu.bd\n" +
                    "Phone: 01967478801\n" +
                    "Name: Manira Afruz\n" +
                    "Id: 171-15-9161\n" +
                    "Email: manira15-9161@diu.edu.bd\n" +
                    "Phone: 01768189752", Toast.LENGTH_LONG).show();
            break;
        case R.id.Share:
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.learn_english_in_bangla&hl=en");
            startActivity(Intent.createChooser(shareIntent, "Share..."));
            break;
        case R.id.Rating:
            Uri uri=Uri.parse("https://play.google.com/store/apps/details?id=com.learn_english_in_bangla&hl=en");
            Intent i=new Intent(Intent.ACTION_VIEW,uri);
            startActivity(i);
            break;
    }
        return true;
    }


    private class GridAdapter extends BaseAdapter{

        @Override
        public int getCount() {

            return Semister.length;
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
            View view1=getLayoutInflater().inflate(R.layout.simple_gridview_row,null);
            TextView textView=view1.findViewById(R.id.textID);
            textView.setText(Semister[position]);
            return view1;
        }
    }

}