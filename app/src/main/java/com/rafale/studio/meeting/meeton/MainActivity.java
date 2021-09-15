package com.rafale.studio.meeting.meeton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 23/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_MA = 4000;
    private ImageView SparkIcon, Logo;
    private TextView Slogan;
    private LinearLayout CopyrightSection;
    private Animation TopAnim, BottomAnim, RightInAnim, LeftInAnim, LeftOutAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        SparkIcon = (ImageView) findViewById(R.id.spark_icon);
        Logo = (ImageView) findViewById(R.id.splash_logo);
        Slogan = (TextView) findViewById(R.id.splash_slogan);
        CopyrightSection = (LinearLayout) findViewById(R.id.splash_copytight);

        TopAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.top_animation);
        BottomAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bottom_animation);
        RightInAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in_right);
        LeftInAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in_left);
        LeftOutAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_out_left);

        SparkIcon.setAnimation(TopAnim);
        Logo.setAnimation(LeftInAnim);
        Slogan.setAnimation(RightInAnim);
        CopyrightSection.setAnimation(BottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent_MA = new Intent(MainActivity.this, MainOptionActivity.class);
                Pair[] pairs_MA = new Pair[3];
                pairs_MA[0] = new Pair<View, String>(Logo, "transition_MA_1");
                pairs_MA[1] = new Pair<View, String>(Slogan, "transition_MA_2");
                pairs_MA[2] = new Pair<View, String>(CopyrightSection, "transition_MA_3");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options_MA = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs_MA);
                    SparkIcon.setAnimation(LeftOutAnim);
                    startActivity(intent_MA, options_MA.toBundle());
                    finish();
                }
            }
        }, SPLASH_MA);

    }// @Override

}// End