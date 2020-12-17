package com.example.tourethiopia.travelagency;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.tourethiopia.R;
import com.example.tourethiopia.hotels.HotelRecyclerAdapter;

public class TravelRcyclerAdapter extends RecyclerView.Adapter<TravelRcyclerAdapter.ViewHolder> {


    private int[] captions;
    private int[] imageid;
    private float[] rating;

    private TravelRcyclerAdapter.Listener listener;
    interface Listener {
        void onClick(int position);
    }

    public TravelRcyclerAdapter(int[] captions, int[] imageid,float[]rating) {
        this.captions = captions;
        this.imageid = imageid;
        this.rating= rating;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }
    @Override
    public int getItemCount(){
        return captions.length;
    }

    public void setListener(TravelRcyclerAdapter.Listener listener){
        this.listener = listener;
    }


    @Override
    public TravelRcyclerAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardviewtravel, parent, false);
        return new TravelRcyclerAdapter.ViewHolder(cv);
    }
    @Override
    public void onBindViewHolder(TravelRcyclerAdapter.ViewHolder holder, final int position){
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.travelimage);
        Drawable drawable =
                ContextCompat.getDrawable(cardView.getContext(), imageid[position]);
        imageView.setImageDrawable(drawable);
        // imageView.setContentDescription(captions[position]);
        TextView textView = (TextView)cardView.findViewById(R.id.travellname);
        textView.setText(captions[position]);

        RatingBar ratingBar = (RatingBar)cardView.findViewById(R.id.travelrate);
        ratingBar.setRating(rating[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }
}
