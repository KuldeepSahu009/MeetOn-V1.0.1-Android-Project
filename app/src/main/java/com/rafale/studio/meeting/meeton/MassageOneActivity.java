package com.rafale.studio.meeting.meeton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MassageOneActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 26/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_MOA = 1000;
    private Class_Preloader_One loader;
    private Button loginBtn_MOA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_massage_one);

        loader = new Class_Preloader_One(MassageOneActivity.this);
        loginBtn_MOA = (Button) findViewById(R.id.login_btn_MOA);

        loginBtn_MOA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_MOA = new Timer();
                timer_MOA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Toast.makeText(MassageOneActivity.this, "Please LogIn", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), LogInActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_MOA);
            }
        });

    }// @Override

    @Override
    public void onBackPressed() {
        Toast.makeText(MassageOneActivity.this, "Verify your email and login", Toast.LENGTH_SHORT).show();
    }

}// END