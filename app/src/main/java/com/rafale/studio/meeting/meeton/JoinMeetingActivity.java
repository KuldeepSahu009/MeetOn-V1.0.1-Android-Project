package com.rafale.studio.meeting.meeton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Timer;
import java.util.TimerTask;

public class JoinMeetingActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 2/08/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_JMA = 1000;
    private Class_Preloader_One loader;
    private TextInputEditText codeInput_JMA;
    private Button scanQrBtn_JMA;
    private ImageView backBtn_JMA, joinBtn_JMA;
    private CheckBox checkBox_JMA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_join_meeting);

        loader = new Class_Preloader_One(JoinMeetingActivity.this);
        backBtn_JMA = (ImageView) findViewById(R.id.back_btn_JMA);
        joinBtn_JMA = (ImageView) findViewById(R.id.join_btn_JMA);
        scanQrBtn_JMA = (Button) findViewById(R.id.scan_code_btn_JMA);
        codeInput_JMA = (TextInputEditText) findViewById(R.id.enter_code_input_JMA);
        checkBox_JMA = (CheckBox) findViewById(R.id.check_box_JMA);

    }// @Override

    @Override
    public void onBackPressed() {
        loader.startLoadingDialog();
        Timer timer_JMA = new Timer();
        timer_JMA.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), DashbordActivity.class));
                finish();
                loader.dismissDilog();
            }
        }, SPLASH_JMA);
    }

}// END