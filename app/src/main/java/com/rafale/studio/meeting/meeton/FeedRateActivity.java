package com.rafale.studio.meeting.meeton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class FeedRateActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 26/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_FRA = 1000;
    private Class_Preloader_One loader;
    private ImageView backBtn_FRA;
    private RatingBar ratingBar_FRA;
    private EditText feedbackInput__FRA;
    private Button sendBtn_FRA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_feed_rate);

        backBtn_FRA = (ImageView) findViewById(R.id.back_btn_FRA);
        ratingBar_FRA = (RatingBar) findViewById(R.id.rating_bar_FRA);
        feedbackInput__FRA = (EditText) findViewById(R.id.feedback_input_FRA);
        sendBtn_FRA = (Button) findViewById(R.id.send_btn_FRA);
        loader = new Class_Preloader_One(FeedRateActivity.this);

        backBtn_FRA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_FRA = new Timer();
                timer_FRA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_FRA);
            }
        });

        sendBtn_FRA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_FRA = new Timer();
                timer_FRA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        loader.dismissDilog();
                        Toast.makeText(FeedRateActivity.this, "Under Construction | @Rafale_Studio", Toast.LENGTH_SHORT).show();
                    }
                }, SPLASH_FRA);
            }
        });

    }// @Override

    @Override
    public void onBackPressed() {
        loader.startLoadingDialog();
        Timer timer_FRA = new Timer();
        timer_FRA.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                finish();
                loader.dismissDilog();
            }
        }, SPLASH_FRA);
    }

}// End