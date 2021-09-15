package com.rafale.studio.meeting.meeton;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class ErrorActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 23/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_EA = 1000;
    private Class_Preloader_One loader;
    private Button retryBtn_ER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_error);

        retryBtn_ER = (Button) findViewById(R.id.retry_btn_ER);
        loader = new Class_Preloader_One(ErrorActivity.this);

        retryBtn_ER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_EA = new Timer();
                timer_EA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), LogInActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_EA);

            }
        });

    }// @Override

}// End