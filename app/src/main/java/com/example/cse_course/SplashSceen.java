package com.example.cse_course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class SplashSceen extends AppCompatActivity {
    private CircleImageView imageView;
    private Animation fromTop;
    private ProgressBar progressBar;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sceen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView=findViewById(R.id.splash_image);

        fromTop= AnimationUtils.loadAnimation(this,R.anim.from_upper);
        imageView.setAnimation(fromTop);

        progressBar=findViewById(R.id.progressBar);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();

            }
        });

        thread.start();
    }

    private void startApp() {
        Intent intent=new Intent(SplashSceen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    private void doWork() {
        for (progress=30;progress<=100;progress=progress+30){

            try {
                Thread.sleep(500);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }
