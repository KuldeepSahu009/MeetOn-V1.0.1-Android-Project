package com.rafale.studio.meeting.meeton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MassageTwoActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 26/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_MTA = 1000;
    private Class_Preloader_One loader;
    private Button loginBtn_MTA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_massage_two);

        loader = new Class_Preloader_One(MassageTwoActivity.this);
        loginBtn_MTA = (Button) findViewById(R.id.login_btn_MTA);

        loginBtn_MTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_MTA = new Timer();
                timer_MTA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Toast.makeText(MassageTwoActivity.this, "Please LogIn", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), LogInActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_MTA);
            }
        });

    }// @Override

    @Override
    public void onBackPressed() {
        Toast.makeText(MassageTwoActivity.this, " Verified, Please LogIn ", Toast.LENGTH_SHORT).show();
    }

}// END