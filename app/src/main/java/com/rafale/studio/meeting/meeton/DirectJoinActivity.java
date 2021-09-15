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

public class DirectJoinActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 26/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_DJA = 1000;
    private Class_Preloader_One loader;
    private ImageView backBtn_DJA;
    private TextInputEditText codeInput_DJA;
    private CheckBox checkBOx_DJA;
    private Button joinBtn_DJA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_direct_join);

        backBtn_DJA = (ImageView) findViewById(R.id.back_btn_DJA);
        codeInput_DJA = (TextInputEditText) findViewById(R.id.input_meeting_code_DJA);
        checkBOx_DJA = (CheckBox) findViewById(R.id.checkbox_DJA);
        joinBtn_DJA = (Button) findViewById(R.id.join_btn_DJA);
        loader = new Class_Preloader_One(DirectJoinActivity.this);

        backBtn_DJA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_DJA = new Timer();
                timer_DJA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), MainOptionActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_DJA);
            }
        });

        joinBtn_DJA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_codeInputDJA = codeInput_DJA.getText().toString();

                if (str_codeInputDJA.isEmpty()) {
                    codeInput_DJA.setError("*required field!");
                    codeInput_DJA.requestFocus();
                    return;
                } else if (checkBOx_DJA.isChecked()) {
                    loader.startLoadingDialog();
                    Toast.makeText(DirectJoinActivity.this, "under construction! @Rafale_Studio", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), DirectJoinActivity.class));
                    finish();
                    loader.dismissDilog();
                } else {
                    checkBOx_DJA.setError("*required field!");
                    checkBOx_DJA.requestFocus();
                    return;
                }
            }
        });

    }// @Override

}// End