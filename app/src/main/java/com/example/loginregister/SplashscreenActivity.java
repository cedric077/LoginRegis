package com.example.loginregister;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class SplashscreenActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private Timer timer;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        progressBar = findViewById(R.id.progressbar);
        progressBar.setProgress(0);

        getSupportActionBar().hide();

        final long period = 100;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //this repeats every 100 ms
                if (i < 100) {
                    progressBar.setProgress(i);
                    i = i + 5;
                } else {
                    //closing the timer
                    timer.cancel();
                    Intent intent = new Intent(SplashscreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    // close this activity
                    finish();
                }
            }
        }, 0, period);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                progressBar.isShown();
//                Intent intent = new Intent(SplashscreenActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        },5000);
    }
}