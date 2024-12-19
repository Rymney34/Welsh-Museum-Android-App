package com.example.welshmuseumapp;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContentLibrary2 extends BaseActivity {
    RecyclerView recyclerView;
    androidx.appcompat.widget.SearchView searchView;
    LibraryCardsAdapter customAdepter;

    ArrayList<LibraryModel> customModelArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_library);

        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.lightGray));

        TextView tx1 = findViewById(R.id.textView);

        tx1.setText(resources.getString(R.string.content_library));

        searchView = findViewById(R.id.searchView);

        ImageView btnBck = findViewById(R.id.btnBack2);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemDisplay();



        btnBck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filter(newText);

                return true;

            }
        });


    }


    private void itemDisplay(){

        String[] namesL = resources.getStringArray(R.array.namesL);

        customModelArrayList.add(new LibraryModel(R.drawable.welsh_bio,namesL[0],"https://biography.wales/"));
        customModelArrayList.add(new LibraryModel(R.drawable.english_welsh,namesL[1],"https://geiriaduracademi.org/?lang=en"));
        customModelArrayList.add(new LibraryModel(R.drawable.celebration_dates,namesL[2],"https://www.wales.com/visit/visiting-wales/celebrated-dates-welsh-calendar"));
        customModelArrayList.add(new LibraryModel(R.drawable.welsh_app,namesL[3],"https://www.termiaduraddysg.cymru/?lang=en"));
        customModelArrayList.add(new LibraryModel(R.drawable.hwb,namesL[4],"https://hwb.gov.wales/"));


        customAdepter = new LibraryCardsAdapter(this,customModelArrayList);
        recyclerView.setAdapter(customAdepter);

    }
    private void filter(String newText) {

        ArrayList<LibraryModel> filtereadList = new ArrayList<>();

        for (LibraryModel item : customModelArrayList){

            if (item.getTitle().toLowerCase().contains(newText.toLowerCase())){

                filtereadList.add(item);

            }

            customAdepter.filterList(filtereadList);

        }

    }

}




