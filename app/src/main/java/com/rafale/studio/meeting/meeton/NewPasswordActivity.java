package com.rafale.studio.meeting.meeton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Timer;
import java.util.TimerTask;

public class NewPasswordActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 24/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_NPA = 1000;
    private Class_Preloader_One loader;
    private ImageView backBtn_NPA;
    private TextInputEditText newPasswordInput_NPA, confirmPassInput_NPA;
    private CheckBox checkBox_NPA;
    private Button submitBtn_NPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_new_password);

        backBtn_NPA = (ImageView) findViewById(R.id.back_btn_NPA);
        newPasswordInput_NPA = (TextInputEditText) findViewById(R.id.new_password_input_NPA);
        confirmPassInput_NPA = (TextInputEditText) findViewById(R.id.confirm_password_input_NPA);
        checkBox_NPA = (CheckBox) findViewById(R.id.check_box_NPA);
        submitBtn_NPA = (Button) findViewById(R.id.submit_btn_NPA);
        loader = new Class_Preloader_One(NewPasswordActivity.this);

        backBtn_NPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_NPA = new Timer();
                timer_NPA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Toast.makeText(NewPasswordActivity.this, "Denied", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), ErrorActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_NPA);
            }
        });

        submitBtn_NPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str_newPass, str_confirmPass;
                str_newPass = newPasswordInput_NPA.getText().toString();
                str_confirmPass = confirmPassInput_NPA.getText().toString();

                if (str_newPass.isEmpty()) {
                    newPasswordInput_NPA.setError("*required field!");
                    newPasswordInput_NPA.requestFocus();
                    return;
                } else if (str_confirmPass.isEmpty()) {
                    confirmPassInput_NPA.setError("*require field!");
                    confirmPassInput_NPA.requestFocus();
                    return;
                } else if (str_newPass.length() == 8) {
                    if (str_newPass.contains("@")) {
                        if (str_newPass == str_confirmPass) {
                            if (checkBox_NPA.isChecked()) {
                                loader.startLoadingDialog();
                                Timer timer_NPA = new Timer();
                                timer_NPA.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(NewPasswordActivity.this, "password changed successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), MassageTwoActivity.class));
                                        finish();
                                        loader.dismissDilog();
                                    }
                                }, SPLASH_NPA);
                            } else {
                                checkBox_NPA.setError("*required!");
                                checkBox_NPA.requestFocus();
                                return;
                            }
                        } else {
                            confirmPassInput_NPA.setError("*password mismatch!");
                            confirmPassInput_NPA.requestFocus();
                            return;
                        }
                    } else {
                        newPasswordInput_NPA.setError("must have one special latter!");
                        newPasswordInput_NPA.requestFocus();
                        return;
                    }
                } else {
                    newPasswordInput_NPA.setError("password must be eight in length!");
                    newPasswordInput_NPA.requestFocus();
                    return;
                }

            }
        });

    }// @Override

    @Override
    public void onBackPressed() {
        loader.startLoadingDialog();
        Timer timer_NPA = new Timer();
        timer_NPA.schedule(new TimerTask() {
            @Override
            public void run() {
                Toast.makeText(NewPasswordActivity.this, "Denied", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), ErrorActivity.class));
                finish();
                loader.dismissDilog();
            }
        }, SPLASH_NPA);
    }

}// End