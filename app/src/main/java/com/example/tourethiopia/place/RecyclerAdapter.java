package com.example.tourethiopia.place;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tourethiopia.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{


    private int[] captions;
    private int[] imageid;

    private Listener listener;
    interface Listener {
        void onClick(int position);
    }

    public RecyclerAdapter(int[] captions, int[] imageid) {
        this.captions = captions;
        this.imageid = imageid;
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

    public void setListener(Listener listener){
        this.listener = listener;
    }


    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview, parent, false);
        return new ViewHolder(cv);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,final int position){
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.info_image);
        Drawable drawable =
                ContextCompat.getDrawable(cardView.getContext(), imageid[position]);
        imageView.setImageDrawable(drawable);
       // imageView.setContentDescription(captions[position]);
        TextView textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(captions[position]);


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

