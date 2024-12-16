package com.example.welshmuseumapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class EventNews extends BaseActivity{



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_news);

        Window window = getWindow();

        window.setStatusBarColor(ContextCompat.getColor(this, R.color.lightGray));

        TextView txtV = findViewById(R.id.textVieweN);

        txtV.setText(resources.getString(R.string.events_and_news));

        ImageView btnBck = findViewById(R.id.btnBack2);



        btnBck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String[] heading = resources.getStringArray(R.array.event_headings);
        String[] desc = resources.getStringArray(R.array.event_descriptions);

        cardCreator(heading[0], desc[0]);


        cardCreator(heading[0], desc[0]);

        cardCreator(heading[1], desc[1]);

        cardCreator(heading[2], desc[2]);

        cardCreator(heading[3], desc[3]);

        cardCreator(heading[4], desc[4]);

        cardCreator(heading[5], desc[5]);

        cardCreator(heading[6], desc[6]);


    }



    public void cardCreator(String heading, String desc) {

        LayoutInflater inflater = LayoutInflater.from(this);
        View newCard = inflater.inflate(R.layout.card_base2, null, false);


        TextView textView = newCard.findViewById(R.id.textViewName);


        TextView textViewDesc = newCard.findViewById(R.id.textViewDesc);

        textView.setText(heading);
        textViewDesc.setText(desc);

        // Set margins for the card
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(16, 210, 16, 16);
        newCard.setLayoutParams(params);


        LinearLayout parentLayout = findViewById(R.id.cards);
        parentLayout.addView(newCard);
    }

}
