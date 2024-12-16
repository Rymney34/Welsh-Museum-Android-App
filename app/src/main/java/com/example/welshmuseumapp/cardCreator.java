package com.example.welshmuseumapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class cardCreator {


    private String heading;
    private String variableValue;
    private String url;


    public cardCreator(String heading, String variableValue, String url) {
        this.heading = heading;
        this.variableValue = variableValue;
        this.url = url;
    }


    public View createCardView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View newCard = inflater.inflate(R.layout.card_base, null, false);

        TextView textView = newCard.findViewById(R.id.textViewName);
        ImageView imageView = newCard.findViewById(R.id.imageViewIcon);

        textView.setText(heading);
        imageView.setImageResource(context.getResources().getIdentifier(variableValue, "drawable", context.getPackageName()));

        // Set the onClickListener for the card to open the URL
        newCard.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(browserIntent);
        });

        // Set margins for the card
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(16, 16, 16, 16);
        newCard.setLayoutParams(params);

        return newCard;
    }
    public String getHeading(Context context) {
        return context.getString(context.getResources().getIdentifier(heading, "string", context.getPackageName()));
    }

    public String getHead1(){
        return heading;
    }
}