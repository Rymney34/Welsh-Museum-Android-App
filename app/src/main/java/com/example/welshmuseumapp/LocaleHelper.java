package com.example.welshmuseumapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;

import java.util.Locale;

    public class LocaleHelper {
        private static final String SELECTED_LANG = "Locale.Helper.Selected.Language";
        public static Context setLocale(Context context, String language) {
            persist(context, language);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

                return updResources(context, language);
            }
            return updateResourcesL(context, language);
        }
        private static void persist(Context context, String language) {

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor = preferences.edit();



            editor.putString(SELECTED_LANG, language);
            editor.apply();
        }

        @TargetApi(Build.VERSION_CODES.N)
        private static Context updResources(Context context, String language) {
            Locale locale = new Locale(language);
            Locale.setDefault(locale);

            Configuration configuration = context.getResources().getConfiguration();
            configuration.setLocale(locale);
            configuration.setLayoutDirection(locale);

            return context.createConfigurationContext(configuration);
        }

        private static Context updateResourcesL(Context context, String language) {
            Locale locale = new Locale(language);
            Locale.setDefault(locale);

            Resources resources = context.getResources();
            Configuration configuration = resources.getConfiguration();

            configuration.locale = locale;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

                configuration.setLayoutDirection(locale);

            }

            resources.updateConfiguration(configuration, resources.getDisplayMetrics());

            return context;
        }
    }
