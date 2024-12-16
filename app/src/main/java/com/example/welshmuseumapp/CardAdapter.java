package com.example.welshmuseumapp;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;
import android.widget.Filter;
import java.util.ArrayList;

public class CardAdapter extends ArrayAdapter<cardCreator> {

    private Context context;
    private List<cardCreator> originalCards; // Original list of all cards
    private List<cardCreator> filteredCards; // Current filtered list

    public CardAdapter(Context context, List<cardCreator> cards) {
        super(context, 0, cards);
        this.context = context;
        this.originalCards = new ArrayList<>(cards); // Copy the original list
        this.filteredCards = new ArrayList<>(cards); // Initially, show all items
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        cardCreator card = getItem(position); // Get the card for the current position
        if (convertView == null) {
            convertView = card.createCardView(context); // Create a new card view if not already available
        }
        return convertView;
    }

    @Override
    public int getCount() {
        return filteredCards.size(); // Return size of the filtered list
    }

    @Override
    public cardCreator getItem(int position) {
        return filteredCards.get(position); // Return the item from the filtered list
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();

                // If query is empty, show the full list in its original order
                if (constraint == null || constraint.length() == 0) {
                    results.values = new ArrayList<>(originalCards);
                    results.count = originalCards.size();
                } else {
                    // Filter the list based on the query
                    String filterPattern = constraint.toString().toLowerCase().trim();
                    List<cardCreator> filteredList = new ArrayList<>();
                    for (cardCreator card : originalCards) {
                        String headingText = card.getHeading(context).toLowerCase();
                        if (headingText.contains(filterPattern)) {
                            filteredList.add(card);
                        }
                    }
                    results.values = filteredList;
                    results.count = filteredList.size();
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredCards.clear();
                filteredCards.addAll((List<cardCreator>) results.values); // Update filtered list
                notifyDataSetChanged(); // Notify the ListView to refresh
            }
        };
    }
}