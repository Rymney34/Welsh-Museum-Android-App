package com.example.welshmuseumapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;

public class ContentLibrary extends BaseActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_library);

        cardCreator("Gazoz","cardiffm", );

    }

    public void cardCreator(String heading, String variableValue){

        View includedLayout = findViewById(R.id.includedLayoutFirst);


        TextView textView = includedLayout.findViewById(R.id.textViewName);
        ImageView imageView = includedLayout.findViewById(R.id.imageViewIcon);

        // Modify the TextView
        textView.setText(heading);

        // Modify the ImageView
        imageView.setImageResource(getResources().getIdentifier(variableValue, "drawable", getPackageName()));
    }
}
