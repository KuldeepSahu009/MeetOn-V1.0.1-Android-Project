package com.rafale.studio.meeting.meeton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Timer;
import java.util.TimerTask;

public class ForgotPasswordActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 23/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_FPA = 1000;
    private Class_Preloader_One loader;
    private ImageView backBtn_FPA;
    private TextInputEditText emailInput_FPA;
    private CheckBox checkBox_FPA;
    private Button sendBtn_FPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forgot_password);

        backBtn_FPA = (ImageView) findViewById(R.id.back_btn_FPA);
        emailInput_FPA = (TextInputEditText) findViewById(R.id.email_input_FPA);
        checkBox_FPA = (CheckBox) findViewById(R.id.check_box_FPA);
        sendBtn_FPA = (Button) findViewById(R.id.send_btn_FPA);
        loader = new Class_Preloader_One(ForgotPasswordActivity.this);

        backBtn_FPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_FPA = new Timer();
                timer_FPA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), LogInActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_FPA);
            }
        });

        sendBtn_FPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_emailInputFPA = emailInput_FPA.getText().toString();
                if (str_emailInputFPA.isEmpty()) {
                    emailInput_FPA.setError("*required field!");
                    emailInput_FPA.requestFocus();
                    return;
                } else if (str_emailInputFPA.length() == 10) {
                    if (checkBox_FPA.isChecked()) {
                        loader.startLoadingDialog();
                        Timer timer_FPA = new Timer();
                        timer_FPA.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Intent intent_FPA = new Intent(ForgotPasswordActivity.this, OtpActivity.class);
                                intent_FPA.putExtra("mobile no show", str_emailInputFPA);
                                startActivity(intent_FPA);
                                finish();
                                loader.dismissDilog();
                            }
                        }, SPLASH_FPA);
                    } else {
                        checkBox_FPA.setError("*required!");
                        checkBox_FPA.requestFocus();
                        return;
                    }
                } else {
                    emailInput_FPA.setError("*invalid number!");
                    emailInput_FPA.requestFocus();
                    return;
                }
            }
        });

    }// @Override

    @Override
    public void onBackPressed() {
        loader.startLoadingDialog();
        Timer timer_FPA = new Timer();
        timer_FPA.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LogInActivity.class));
                finish();
                loader.dismissDilog();
            }
        }, SPLASH_FPA);
    }
}// End