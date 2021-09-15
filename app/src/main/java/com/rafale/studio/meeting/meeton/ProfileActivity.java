package com.rafale.studio.meeting.meeton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class ProfileActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 23/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private static int SPLASH_PA = 1000;
    private static final int PICK_IMG_CODE = 1;
    private Uri imageUri;
    private Class_Preloader_One loader;
    private ImageView backBtnPA;
    private ConstraintLayout editProfile, qrCode, feedBack, supPort, shareShare;
    private Button logOutBtn;
    private ImageFilterView profile_photo_upload_PA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);

        loader = new Class_Preloader_One(ProfileActivity.this);
        backBtnPA = (ImageView) findViewById(R.id.back_btn_PA);
        editProfile = (ConstraintLayout) findViewById(R.id.edit_profile_area_PA);
        qrCode = (ConstraintLayout) findViewById(R.id.qr_code_area_PA);
        feedBack = (ConstraintLayout) findViewById(R.id.feedback_area_PA);
        supPort = (ConstraintLayout) findViewById(R.id.support_area_PA);
        shareShare = (ConstraintLayout) findViewById(R.id.share_area_PA);
        logOutBtn = (Button) findViewById(R.id.logout_btn_PA);
        profile_photo_upload_PA = (ImageFilterView) findViewById(R.id.profile_icon_PA);

        backBtnPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_PA = new Timer();
                timer_PA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), DashbordActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_PA);
            }
        });

        profile_photo_upload_PA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pickImageIntent_PA = new Intent();
                pickImageIntent_PA.setType("image/*");
                pickImageIntent_PA.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(pickImageIntent_PA, "sellect picture"), PICK_IMG_CODE);

            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Edit Profile | Under Construction", Toast.LENGTH_SHORT).show();
            }
        });

        qrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "processing...", Toast.LENGTH_SHORT).show();
                loader.startLoadingDialog();
                Timer timer_PA = new Timer();
                timer_PA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), QRCodeOneActvity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_PA);
            }
        });

        feedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_PA = new Timer();
                timer_PA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), FeedRateActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_PA);
            }
        });

        supPort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader.startLoadingDialog();
                Timer timer_PA = new Timer();
                timer_PA.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), SupportActivity.class));
                        finish();
                        loader.dismissDilog();
                    }
                }, SPLASH_PA);
            }
        });

        shareShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Share", Toast.LENGTH_SHORT).show();
                String body = "Download this App";
                String sub = "http://skywarrior09.gq";

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("Also share with...");
                intent.putExtra(Intent.EXTRA_TEXT, body);
                intent.putExtra(Intent.EXTRA_TEXT, sub);
                startActivity(Intent.createChooser(intent, "Share using"));
            }
        });

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder_PA = new AlertDialog.Builder(ProfileActivity.this);
                builder_PA.setTitle("SignOut");
                builder_PA.setMessage("Are you really want to logOut form meetOn!");
                builder_PA.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        loader.startLoadingDialog();
                        Timer timer_PA = new Timer();
                        timer_PA.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                loader.dismissDilog();
                                System.exit(0);
                            }
                        }, SPLASH_PA);
                    }
                });
                builder_PA.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProfileActivity.this, "please continue meet", Toast.LENGTH_SHORT).show();
                    }
                });
                builder_PA.create();
                builder_PA.show();
            }
        });

    }// @Override

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMG_CODE && requestCode == RESULT_OK) {
            imageUri = data.getData();
            try {
                Bitmap bitmap_PA = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                profile_photo_upload_PA.setImageBitmap(bitmap_PA);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onBackPressed() {
        loader.startLoadingDialog();
        Timer timer_PA = new Timer();
        timer_PA.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), DashbordActivity.class));
                finish();
                loader.dismissDilog();
            }
        }, SPLASH_PA);
    }

}// End