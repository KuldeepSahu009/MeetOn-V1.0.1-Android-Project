package com.rafale.studio.meeting.meeton;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class CoviedActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 23/07/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     * Developed Under: @Rafale_Studio
     */

    private FragmentManager fragmentManager_CA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_covied);

        fragmentManager_CA = getSupportFragmentManager();

        final PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataForOnBording());

        FragmentTransaction fragmentTransaction = fragmentManager_CA.beginTransaction();
        fragmentTransaction.add(R.id.covid_container, paperOnboardingFragment);
        fragmentTransaction.commit();

    }// @Override

    private ArrayList<PaperOnboardingPage> getDataForOnBording() {
        PaperOnboardingPage UI_1 = new PaperOnboardingPage("Covid-19", "Take Precautions",
                Color.parseColor("#ffffff"), R.drawable.covid_ui_1, R.drawable.aaroigya_setu_logo);

        PaperOnboardingPage UI_2 = new PaperOnboardingPage("Covid-10", "Put on Mask",
                Color.parseColor("#ffcc33"), R.drawable.covid_ui_2, R.drawable.promote_vaccine_logo);

        PaperOnboardingPage UI_3 = new PaperOnboardingPage("Covid-13", "Seek Doctor's Advice",
                Color.parseColor("#EA80FC"), R.drawable.covid_ui_3, R.drawable.ayush_ministry_logo);

        ArrayList<PaperOnboardingPage> element = new ArrayList<>();
        element.add(UI_1);
        element.add(UI_2);
        element.add(UI_3);
        return element;
    }

}// End