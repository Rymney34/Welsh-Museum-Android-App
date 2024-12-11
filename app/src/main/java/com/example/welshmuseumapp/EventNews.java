package com.example.welshmuseumapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class EventNews extends BaseActivity{



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_news);

        TextView txtV = findViewById(R.id.textVieweN);

        txtV.setText(resources.getString(R.string.events_and_news));

        ImageView btnBck = findViewById(R.id.btnBack2);



        btnBck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cardCreator("stDwynd", "stDwyndDesc");


        cardCreator("GwylName", "GwylDesc");

        cardCreator("DyddM", "DyddMText");

        cardCreator("stDavid", "stDavidDesc");

        cardCreator("pancakeD", "pancakeDesc");

        cardCreator("lDay", "lDayDesc");

        cardCreator("easterD", "easterDesc");

        cardCreator("calanMai", "calanMaiDesc");


    }



    public void cardCreator(String heading, String desc) {

        LayoutInflater inflater = LayoutInflater.from(this);
        View newCard = inflater.inflate(R.layout.card_base2, null, false);


        TextView textView = newCard.findViewById(R.id.textViewName);


        TextView textViewDesc = newCard.findViewById(R.id.textViewDesc);

        textView.setText(getResources().getIdentifier(heading, "string", getPackageName()));
        textViewDesc.setText(getResources().getIdentifier(desc, "string", getPackageName()));

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
