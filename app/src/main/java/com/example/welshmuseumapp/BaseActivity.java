package com.example.welshmuseumapp;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    Context context;
    Resources resources;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String savedLanguage = LanguagePreference.getLanguage(this);
        context = LocaleHelper.setLocale(this, savedLanguage);
        resources = context.getResources();

    }


}
