package com.rafale.studio.meeting.meeton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SupportActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 25/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_SA = 1000;
    private Class_Preloader_One loader;
    private ImageView backBtn_SA;
    private TextView callSupport_SA, emailSupport_SA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_support);

        backBtn_SA = (ImageView) findViewById(R.id.back_btn_SA);
        callSupport_SA = (TextView) findViewById(R.id.call_support_SA);
        emailSupport_SA = (TextView) findViewById(R.id.email_support_SA);
        loader = new Class_Preloader_One(SupportActivity.this);

        backBtn_SA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_SA = new Timer();
                timer_SA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_SA);
            }
        });

        callSupport_SA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_SA = new Timer();
                timer_SA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        loader.dismissDilog();
                        Toast.makeText(SupportActivity.this, "Call Support | Under Construction", Toast.LENGTH_SHORT).show();
                    }
                }, SPLASH_SA);
            }
        });

        emailSupport_SA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_SA = new Timer();
                timer_SA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        loader.dismissDilog();
                        Toast.makeText(SupportActivity.this, "Email Support | Under Construction", Toast.LENGTH_SHORT).show();
                    }
                }, SPLASH_SA);
            }
        });

    }// @Override

    @Override
    public void onBackPressed() {
        loader.startLoadingDialog();
        Timer timer_SA = new Timer();
        timer_SA.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                finish();
                loader.dismissDilog();
            }
        }, SPLASH_SA);
    }

}// End