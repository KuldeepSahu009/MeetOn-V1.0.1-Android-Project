package com.rafale.studio.meeting.meeton;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

public class MassageThreeActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 27/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_MTHA = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_massage_three);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MassageThreeActivity.this, "please continue...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MassageOneActivity.class));
                finish();
            }
        }, SPLASH_MTHA);

    }// @Override

}// End