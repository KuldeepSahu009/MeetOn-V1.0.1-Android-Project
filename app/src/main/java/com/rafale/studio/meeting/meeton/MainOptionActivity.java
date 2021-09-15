package com.rafale.studio.meeting.meeton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.Timer;
import java.util.TimerTask;

public class MainOptionActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 23/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private Class_Preloader_One preloader;
    private static int SPLASH_MOA = 1000;
    private ViewFlipper flipper_1;
    private Button HostBtn_MOA;
    public AdRequest adRequest;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_option);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adRequest = new AdRequest.Builder().build();
        flipper_1 = (ViewFlipper) findViewById(R.id.flipper_slider_WCAC);
        HostBtn_MOA = (Button) findViewById(R.id.host_btn_moa);
        preloader = new Class_Preloader_One(MainOptionActivity.this);

        HostBtn_MOA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preloader.startLoadingDialog();
                Timer timer_MOA = new Timer();
                timer_MOA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainOptionActivity.this, LogInActivity.class));
                        finish();
                        preloader.dismissDilog();
                    }
                }, SPLASH_MOA);
            }
        });

        InterstitialAd.load(this, getString(R.string.AdMob_AD_ID), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("TAG", loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });

        int image_array[] = {R.drawable.fliper_ui_1, R.drawable.fliper_ui_2, R.drawable.fliper_ui_3, R.drawable.fliper_ui_4};
        for (int i = 0; i < image_array.length; i++)
            showimage(image_array[i]);

    }// @Override

    private void showimage(int img) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);

        flipper_1.addView(imageView);
        flipper_1.setFlipInterval(2000);
        flipper_1.setAutoStart(true);
        flipper_1.setInAnimation(this, android.R.anim.slide_in_left);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder_1 = new AlertDialog.Builder(this);
        builder_1.setTitle("Exit");
        builder_1.setMessage("Are you really want to exit.");
        builder_1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        });
        builder_1.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder_1.create();
        builder_1.show();
    }

    public void DirectJoinBtn(View view) {

        if (mInterstitialAd != null) {
            Toast.makeText(MainOptionActivity.this, "loading...", Toast.LENGTH_SHORT).show();
            mInterstitialAd.show(MainOptionActivity.this);
            startActivity(new Intent(getApplicationContext(), DirectJoinActivity.class));

        } else {
            Toast.makeText(MainOptionActivity.this, "please check your network connection", Toast.LENGTH_SHORT).show();
        }
    }

} // End