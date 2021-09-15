package com.rafale.studio.meeting.meeton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class PrivacyPolicyActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 25/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_PPA = 1000;
    private Class_Preloader_One loader;
    private ImageView backBtn_PPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_privacy_policy);

        loader = new Class_Preloader_One(PrivacyPolicyActivity.this);
        backBtn_PPA = (ImageView) findViewById(R.id.back_btn_PPA);

        backBtn_PPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_PPA = new Timer();
                timer_PPA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), LogInActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_PPA);
            }
        });

    }// @Override

    @Override
    public void onBackPressed() {
        loader.startLoadingDialog();
        Timer timer_PPA = new Timer();
        timer_PPA.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LogInActivity.class));
                finish();
                loader.dismissDilog();
            }
        }, SPLASH_PPA);
    }

}// END