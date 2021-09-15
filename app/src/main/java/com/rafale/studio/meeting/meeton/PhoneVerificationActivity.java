package com.rafale.studio.meeting.meeton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Timer;
import java.util.TimerTask;

public class PhoneVerificationActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 27/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_PVA = 1000;
    private Class_Preloader_One loader;
    private Button sendBtn_PVA, submitBtn_PVA;
    private TextInputEditText phoneInput_PVA;
    private PinView otpInput_PVA;
    private TextView numShow_PVA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_phone_verification);

        loader = new Class_Preloader_One(PhoneVerificationActivity.this);
        sendBtn_PVA = (Button) findViewById(R.id.send_btn_PVA);
        submitBtn_PVA = (Button) findViewById(R.id.submit_btn_PVA);
        phoneInput_PVA = (TextInputEditText) findViewById(R.id.phone_input_PVA);
        otpInput_PVA = (PinView) findViewById(R.id.pin_view_PVA);
        numShow_PVA = (TextView) findViewById(R.id.number_show_PVA);

        sendBtn_PVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_phoneInputPVA = phoneInput_PVA.getText().toString();

                if (str_phoneInputPVA.isEmpty()) {
                    phoneInput_PVA.setError("*required field!");
                    phoneInput_PVA.requestFocus();
                    return;
                } else if (str_phoneInputPVA.length() == 8) {
                    loader.startLoadingDialog();
                    Timer timer_PVA = new Timer();
                    timer_PVA.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Intent intent_PVA = new Intent(PhoneVerificationActivity.this, PhoneVerificationActivity.class);
                            intent_PVA.putExtra("numberShowPVA", str_phoneInputPVA);
                            Toast.makeText(PhoneVerificationActivity.this, " OTP sent successfully ", Toast.LENGTH_SHORT).show();
                            startActivity(intent_PVA);
                            loader.dismissDilog();
                        }
                    }, SPLASH_PVA);

                } else {
                    phoneInput_PVA.setError("*invalid number!");
                    phoneInput_PVA.requestFocus();
                    return;
                }
            }
        });

        String str_numShowPVA = getIntent().getStringExtra("numberShowPVA");
        numShow_PVA.setText(str_numShowPVA);

        submitBtn_PVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_OtpInputPVA = otpInput_PVA.getText().toString();

                if (str_OtpInputPVA.isEmpty()) {
                    otpInput_PVA.setError("*required field!");
                    otpInput_PVA.requestFocus();
                    return;
                } else {
                    loader.startLoadingDialog();
                    Timer timer_PVA = new Timer();
                    timer_PVA.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Toast.makeText(PhoneVerificationActivity.this, " verified successfully ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MassageThreeActivity.class));
                            finish();
                            loader.dismissDilog();
                        }
                    }, SPLASH_PVA);
                }

            }
        });

    }// @Override

    @Override
    public void onBackPressed() {
        Toast.makeText(PhoneVerificationActivity.this, " verification process is runing ", Toast.LENGTH_SHORT).show();
    }

}// End