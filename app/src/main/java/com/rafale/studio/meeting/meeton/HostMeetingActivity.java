package com.rafale.studio.meeting.meeton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.zxing.WriterException;

import java.util.Timer;
import java.util.TimerTask;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class HostMeetingActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 2/08/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_HMA = 1000;
    private Class_Preloader_One loader;
    private TextInputEditText codeInput_HMA;
    private Button generateQrBtn_HMA;
    private ImageView backBtn_HMA, hostBtn_HMA, qrShowArea_HMA, shareBtn_HMA;
    private CheckBox checkBox_HMA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_host_meeting);

        loader = new Class_Preloader_One(HostMeetingActivity.this);
        backBtn_HMA = (ImageView) findViewById(R.id.back_btn_HMA);
        hostBtn_HMA = (ImageView) findViewById(R.id.host_btn_HMA);
        generateQrBtn_HMA = (Button) findViewById(R.id.generate_code_btn_HMA);
        codeInput_HMA = (TextInputEditText) findViewById(R.id.generate_code_input_HMA);
        checkBox_HMA = (CheckBox) findViewById(R.id.check_box_HMA);
        qrShowArea_HMA = (ImageView) findViewById(R.id.qr_show_area_HMA);
        shareBtn_HMA = (ImageView) findViewById(R.id.share_btn_HMA);

        backBtn_HMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_HMA = new Timer();
                timer_HMA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), DashbordActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_HMA);
            }
        });

        generateQrBtn_HMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_codeInputHMA = codeInput_HMA.getText().toString();

                if (str_codeInputHMA.isEmpty()) {
                    codeInput_HMA.setError("*Enter code to generate QR");
                    codeInput_HMA.requestFocus();
                    return;
                } else if (str_codeInputHMA.length() == 8) {

                    if (checkBox_HMA.isChecked()) {
                        shareBtn_HMA.setVisibility(View.VISIBLE);
                        QRGEncoder qrgEncoder_HMA = new QRGEncoder(str_codeInputHMA, null, QRGContents.Type.TEXT, 800);
                        Bitmap bitmap_HMA = qrgEncoder_HMA.getBitmap();
                        shareBtn_HMA.setImageBitmap(bitmap_HMA);
                    } else {
                        checkBox_HMA.setError("*required field");
                        checkBox_HMA.requestFocus();
                        return;
                    }

                } else {
                    codeInput_HMA.setError("*code must be 8 in length!");
                    codeInput_HMA.requestFocus();
                    return;
                }
            }
        });

    }// @Override

    @Override
    public void onBackPressed() {
        loader.startLoadingDialog();
        Timer timer_HMA = new Timer();
        timer_HMA.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), DashbordActivity.class));
                finish();
                loader.dismissDilog();
            }
        }, SPLASH_HMA);
    }

}// END