package com.example.welshmuseumapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class ContentLibrary extends BaseActivity{
    ArrayAdapter<String> adapter;


    ArrayList<String> mylist;

    SearchView search;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_library);

        ImageView btnBck = findViewById(R.id.btnBack2);

        SearchView search = findViewById(R.id.search);

        ListView listView = findViewById(R.id.listview);

        mylist = new ArrayList<>();
        mylist.add("C");
        mylist.add("C");
        mylist.add("C");
        mylist.add("C++");
        mylist.add("C#");
        mylist.add("Java");
        mylist.add("Advanced java");
        mylist.add("Interview prep with c++");
        mylist.add("Interview prep with java");
        mylist.add("data structures with c");
        mylist.add("data structures with java");

        adapter = new ArrayAdapter<>(ContentLibrary.this, android.R.layout.simple_list_item_1, mylist);
        listView.setAdapter(adapter);

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(mylist.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(ContentLibrary.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                    adapter.getFilter().filter(newText);
                return false;
            }
        });


        btnBck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        cardCreator("celebrated","celebration_dates","https://www.wales.com/visit/visiting-wales/celebrated-dates-welsh-calendar");
//
//        cardCreator("welshBio","welsh_bio","https://biography.wales/");
//
//        cardCreator("hwb","hwb","https://hwb.gov.wales/");
//
//
//        cardCreator("welshAcademy","english_welsh","https://geiriaduracademi.org/?lang=en");
//
//        cardCreator("y_ta","welsh_app","https://www.termiaduraddysg.cymru/?lang=en");
//    }
//
//    public void cardCreator(String heading, String variableValue, String url) {
//
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View newCard = inflater.inflate(R.layout.card_base, null, false);
//
//
//        newCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                startActivity(browserIntent);
//            }
//        });
//
//
//        TextView textView = newCard.findViewById(R.id.textViewName);
//        ImageView imageView = newCard.findViewById(R.id.imageViewIcon);
//
//        textView.setText(getResources().getIdentifier(heading, "string", getPackageName()));
//        imageView.setImageResource(getResources().getIdentifier(variableValue, "drawable", getPackageName()));
//
//        // Set margins for the card
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//        );
//        params.setMargins(16, 300, 16, 16);
//        newCard.setLayoutParams(params);
//
//
//        LinearLayout parentLayout = findViewById(R.id.cards);
//        parentLayout.addView(newCard);
    }
}
