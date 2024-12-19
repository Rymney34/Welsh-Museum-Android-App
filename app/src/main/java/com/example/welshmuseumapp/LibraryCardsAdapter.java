package com.example.welshmuseumapp;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LibraryCardsAdapter extends RecyclerView.Adapter<LibraryCardHolder> {
    Context context;
    ArrayList<LibraryModel> customModelArrayList = new ArrayList<>();

    public LibraryCardsAdapter(Context context, ArrayList<LibraryModel> customModelArrayList) {
        this.context = context;
        this.customModelArrayList = customModelArrayList;
    }
    @Override
    public int getItemCount() {
        return customModelArrayList.size();
    }

    @NonNull
    @Override
    public LibraryCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LibraryCardHolder(LayoutInflater.from(context).inflate(R.layout.card_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull LibraryCardHolder holder, int position) {

        String url = customModelArrayList.get(position).getUrl();

        holder.imageView.setImageResource(customModelArrayList.get(position).getImage());
        holder.tvTitle.setText(customModelArrayList.get(position).getTitle());


        holder.cardItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(browserIntent);
            }
        });
    }


    public void filterList(ArrayList<LibraryModel> filtereadList ){

        customModelArrayList = filtereadList;
        notifyDataSetChanged();
    }

}
