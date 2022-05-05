package com.example.monumental_v2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;


public class AppPreferenceActivity extends PreferenceActivity{

    @Override
    public void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
    }

    @Override
    public void onBuildHeaders(List<Header> target){
        loadHeadersFromResource(R.xml.prefheaders, target);
    }

    @Override
    protected boolean isValidFragment(String fragmentname){
        return true;
    }

    public static class PrefFragment extends PreferenceFragment{

        @Override
        public void onCreate(Bundle savedInstancesState){
            super.onCreate(savedInstancesState);

        PreferenceManager.setDefaultValues(getActivity(), R.xml.myapppreferences, false);
        addPreferencesFromResource(R.xml.myapppreferences);


        }


    }

}
