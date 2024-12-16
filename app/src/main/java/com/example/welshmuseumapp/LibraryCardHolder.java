package com.example.welshmuseumapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class LibraryCardHolder extends RecyclerView.ViewHolder {

    ImageView imageView;


    TextView tvTitle;


    CardView cardItemView;


    public LibraryCardHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        cardItemView = itemView.findViewById(R.id.cardItemView);






    }
}
