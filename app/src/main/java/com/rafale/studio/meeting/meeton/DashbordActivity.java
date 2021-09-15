package com.rafale.studio.meeting.meeton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class DashbordActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 30/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_DBA = 1000;
    private Class_Preloader_One loader;
    private TextView meetOnText;
    private ImageView ProfileIcon, HostIcon, JoinIcon;
    private LinearLayout QrCodeArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashbord);

        loader = new Class_Preloader_One(DashbordActivity.this);
        meetOnText = (TextView) findViewById(R.id.home_logo_text_DBA);
        ProfileIcon = (ImageView) findViewById(R.id.profile_icon_DBA);
        HostIcon = (ImageView) findViewById(R.id.card_one_img_DBA);
        JoinIcon = (ImageView) findViewById(R.id.card_two_img_DBA);
        QrCodeArea = (LinearLayout) findViewById(R.id.fast_join_area_DBA);

        meetOnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DashbordActivity.this, "MeetOn | Connect with meeting", Toast.LENGTH_SHORT).show();
            }
        });

        ProfileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_DBA = new Intent(getApplicationContext(), ProfileActivity.class);

                Pair[] pairs_DBA = new Pair[1];
                pairs_DBA[0] = new Pair<View, String>(ProfileIcon, "transition_DBA_1");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options_DBA = ActivityOptions.makeSceneTransitionAnimation(DashbordActivity.this, pairs_DBA);
                    startActivity(intent_DBA, options_DBA.toBundle());
                    finish();
                }
            }
        });

        QrCodeArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_DBA = new Timer();
                timer_DBA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), FastJoinActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_DBA);
            }
        });

        HostIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_DBA = new Timer();
                timer_DBA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), HostMeetingActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_DBA);
            }
        });

        JoinIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_DBA = new Timer();
                timer_DBA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), JoinMeetingActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_DBA);
            }
        });

    }// @Override

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder_DBA = new AlertDialog.Builder(DashbordActivity.this);
        builder_DBA.setTitle("Exit");
        builder_DBA.setMessage("Are you really want to move here!");
        builder_DBA.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getApplicationContext(), LogOutingScreenActivity.class));
                finish();
            }
        });
        builder_DBA.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DashbordActivity.this, "Thank You", Toast.LENGTH_SHORT).show();
            }
        });
        builder_DBA.create();
        builder_DBA.show();
    }

}//END