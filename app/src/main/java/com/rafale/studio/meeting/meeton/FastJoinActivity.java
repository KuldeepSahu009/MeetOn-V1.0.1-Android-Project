package com.rafale.studio.meeting.meeton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

import java.util.Timer;
import java.util.TimerTask;

public class FastJoinActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 2/08/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_FJA = 1000;
    private Class_Preloader_One loader;
    private ImageView backBtn_FJA;
    private Button joinBtn_FJA;
    private CodeScanner mCodeScanner;
    private TextView codeShowBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fast_join);

        loader = new Class_Preloader_One(FastJoinActivity.this);
        backBtn_FJA = (ImageView) findViewById(R.id.back_btn_FJA);
        joinBtn_FJA = (Button) findViewById(R.id.join_btn_FJA);
        codeShowBox = (TextView) findViewById(R.id.code_show_box_FJA);

        backBtn_FJA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_FJA = new Timer();
                timer_FJA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), DashbordActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_FJA);
            }
        });

        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String strResult_FJA = result.getText().toString().trim();
                        codeShowBox.setText(strResult_FJA);
                        //Toast.makeText(FastJoinActivity.this, result.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });

    }// @Override

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        loader.startLoadingDialog();
        Timer timer_FJA = new Timer();
        timer_FJA.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), DashbordActivity.class));
                finish();
                loader.dismissDilog();
            }
        }, SPLASH_FJA);
    }

}// END