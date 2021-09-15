package com.rafale.studio.meeting.meeton;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import javax.security.auth.callback.CallbackHandler;

public class SignUpActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 23/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_SUA = 1000;
    private Class_Preloader_One laoder;
    private ImageView backBtn_SUA;
    private TextInputEditText fullNameInput_SUA, emailInput_SUA, dobInput_SUA, passwordInput_SUA, confirmPassInput_SUA;
    private CheckBox checkBox_SUA;
    private Button submitBtn_SUA, alreadyAccount_SUA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        backBtn_SUA = (ImageView) findViewById(R.id.back_btn_SUA);
        fullNameInput_SUA = (TextInputEditText) findViewById(R.id.full_name_input_SUA);
        emailInput_SUA = (TextInputEditText) findViewById(R.id.email_input_SUA);
        dobInput_SUA = (TextInputEditText) findViewById(R.id.dob_input_SUA);
        passwordInput_SUA = (TextInputEditText) findViewById(R.id.password_input_SUA);
        confirmPassInput_SUA = (TextInputEditText) findViewById(R.id.confirm_password_input_SUA);
        checkBox_SUA = (CheckBox) findViewById(R.id.check_box_SUA);
        submitBtn_SUA = (Button) findViewById(R.id.submit_btn_SUA);
        alreadyAccount_SUA = (Button) findViewById(R.id.already_account_btn_SUA);
        laoder = new Class_Preloader_One(SignUpActivity.this);

    }// @Override

}// End