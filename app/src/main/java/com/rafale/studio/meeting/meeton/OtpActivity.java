package com.rafale.studio.meeting.meeton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chaos.view.PinView;

import java.util.Timer;
import java.util.TimerTask;

public class OtpActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 24/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */
    private static int SPLASH_OA = 1000;
    private Class_Preloader_One loader;
    private ImageView backBtn_OA, arrowBtn_OA;
    private PinView pinView_OA;
    private TextView mobileNumberShower;
    private Button resendOtpBtn_OA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_otp);

        backBtn_OA = (ImageView) findViewById(R.id.back_btn_OA);
        arrowBtn_OA = (ImageView) findViewById(R.id.arrow_btn_OA);
        pinView_OA = (PinView) findViewById(R.id.pin_view_OA);
        mobileNumberShower = (TextView) findViewById(R.id.mobile_number_show_OA);
        resendOtpBtn_OA = (Button) findViewById(R.id.resend_btn_OA);

        String str_noShow = getIntent().getStringExtra("mobile no show");
        mobileNumberShower.setText(str_noShow);

        backBtn_OA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_OA = new Timer();
                timer_OA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), ForgotPasswordActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_OA);
            }
        });

        arrowBtn_OA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_otpInputOA = pinView_OA.getText().toString();

                if (str_otpInputOA.isEmpty()) {
                    pinView_OA.setError("*required field!");
                    pinView_OA.requestFocus();
                    return;
                } else {
                    loader.startLoadingDialog();
                    Timer timer_OA = new Timer();
                    timer_OA.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            startActivity(new Intent(getApplicationContext(), NewPasswordActivity.class));
                            finish();
                            loader.dismissDilog();
                        }
                    }, SPLASH_OA);
                }
            }
        });

        resendOtpBtn_OA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_OA = new Timer();
                timer_OA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), OtpActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_OA);
            }
        });

    }// @Override

    @Override
    public void onBackPressed() {
        loader.startLoadingDialog();
        Timer timer_OA = new Timer();
        timer_OA.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), ForgotPasswordActivity.class));
                finish();
                loader.dismissDilog();
            }
        }, SPLASH_OA);
    }
}// End