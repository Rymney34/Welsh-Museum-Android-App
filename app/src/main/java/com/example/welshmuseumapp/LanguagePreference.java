package com.example.welshmuseumapp;

import android.content.Context;
import android.content.SharedPreferences;

public class LanguagePreference {

    private static final String PREF_NAME = "language_pref";
    private static final String KEY_LANGUAGE = "key_language";

    public static void saveLanguage(Context context, String languageCode) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_LANGUAGE, languageCode);
        editor.apply();
    }

    public static String getLanguage(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getString(KEY_LANGUAGE, "en"); // Default to English
    }
}