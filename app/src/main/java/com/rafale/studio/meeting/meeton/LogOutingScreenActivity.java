package com.rafale.studio.meeting.meeton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;

import java.util.TimerTask;

public class LogOutingScreenActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 02/08/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_LOSA = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_outing_screen);

        new Handler().postDelayed(new TimerTask() {
            @Override
            public void run() {
                System.exit(0);
            }
        }, SPLASH_LOSA);

    }// @Override

}// End