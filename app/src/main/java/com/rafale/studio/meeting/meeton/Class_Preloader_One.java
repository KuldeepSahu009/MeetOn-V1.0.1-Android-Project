package com.rafale.studio.meeting.meeton;

import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

class Class_Preloader_One {

    private AppCompatActivity activity;
    private AlertDialog dialog;

    Class_Preloader_One(AppCompatActivity myActivity) {
        activity = myActivity;
    }

    void startLoadingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.layout_pre_loader_1, null));
        builder.setCancelable(false);

        dialog = builder.create();
        dialog.show();
    }

    void dismissDilog() {
        dialog.dismiss();
    }

}
