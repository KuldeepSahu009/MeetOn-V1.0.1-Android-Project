package com.rafale.studio.meeting.meeton;

import android.content.Intent;
import android.os.Bundle;
import android.service.quicksettings.Tile;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Timer;
import java.util.TimerTask;

public class LogInActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 23/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_LIA = 1000;
    private ImageView backBtn_LIA;
    private TextInputEditText emailInput_LIA, passwordInput_LIA;
    private Button forgotPasswordBtn_LIA, nextBtn_LIA, newUserBtn_LIA;
    private TextView privacyBtn_LIA, termConditionsBtn_LIA;
    private Class_Preloader_One loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_log_in);

        backBtn_LIA = (ImageView) findViewById(R.id.back_btn_LIA);
        emailInput_LIA = (TextInputEditText) findViewById(R.id.email_input_LIA);
        passwordInput_LIA = (TextInputEditText) findViewById(R.id.password_input_LIA);
        forgotPasswordBtn_LIA = (Button) findViewById(R.id.forgot_password_LIA);
        nextBtn_LIA = (Button) findViewById(R.id.next_btn_LIA);
        newUserBtn_LIA = (Button) findViewById(R.id.new_user_btn_LIA);
        privacyBtn_LIA = (TextView) findViewById(R.id.privacy_policy_LIA);
        termConditionsBtn_LIA = (TextView) findViewById(R.id.term_condition_LIA);
        loader = new Class_Preloader_One(LogInActivity.this);

        backBtn_LIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_LIA = new Timer();
                timer_LIA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), MainOptionActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_LIA);
            }
        });

        forgotPasswordBtn_LIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_LIA = new Timer();
                timer_LIA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), ForgotPasswordActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_LIA);
            }
        });

        nextBtn_LIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str_emailInputLIA, str_passwordInputLIA;
                str_emailInputLIA = emailInput_LIA.getText().toString();
                str_passwordInputLIA = passwordInput_LIA.getText().toString();

                if (str_emailInputLIA.isEmpty()) {
                    emailInput_LIA.setError("*required field!");
                    emailInput_LIA.requestFocus();
                    return;
                } else if (str_passwordInputLIA.isEmpty()) {
                    passwordInput_LIA.setError("*required field!");
                    passwordInput_LIA.requestFocus();
                    return;
                } else if (str_emailInputLIA.endsWith("@gmail.com")) {

                    if (str_passwordInputLIA.length() != 8) {
                        passwordInput_LIA.setError("*invalid password!");
                        passwordInput_LIA.requestFocus();
                        return;
                    } else if (str_passwordInputLIA.contains("@")) {
                        loader.startLoadingDialog();
                        Toast.makeText(LogInActivity.this, "loading...", Toast.LENGTH_SHORT).show();
                        Timer timer_LIA = new Timer();
                        timer_LIA.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                                loader.dismissDilog();
                            }
                        }, SPLASH_LIA);
                    } else {
                        loader.startLoadingDialog();
                        Toast.makeText(LogInActivity.this, "*invalid password!", Toast.LENGTH_SHORT).show();
                        Timer timer_LIA = new Timer();
                        timer_LIA.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                startActivity(new Intent(getApplicationContext(), ErrorActivity.class));
                                finish();
                                loader.dismissDilog();
                            }
                        }, SPLASH_LIA);
                    }
                } else {
                    loader.startLoadingDialog();
                    Toast.makeText(LogInActivity.this, "*invalid mail!", Toast.LENGTH_SHORT).show();
                    Timer timer_LIA = new Timer();
                    timer_LIA.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            startActivity(new Intent(getApplicationContext(), ErrorActivity.class));
                            finish();
                            loader.dismissDilog();
                        }
                    }, SPLASH_LIA);
                }
            }
        });

        newUserBtn_LIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_LIA = new Timer();
                timer_LIA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_LIA);
            }
        });

        privacyBtn_LIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_LIA = new Timer();
                timer_LIA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), PrivacyPolicyActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_LIA);
            }
        });

        termConditionsBtn_LIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_LIA = new Timer();
                timer_LIA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), TermConditionsActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_LIA);
            }
        });

    }// @Override

    @Override
    public void onBackPressed() {
        loader.startLoadingDialog();
        Timer timer_LIA = new Timer();
        timer_LIA.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainOptionActivity.class));
                finish();
                loader.dismissDilog();
            }
        }, SPLASH_LIA);
    }

}// End