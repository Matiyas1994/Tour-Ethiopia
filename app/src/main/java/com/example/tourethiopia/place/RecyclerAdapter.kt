package com.example.tourethiopia.place

import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.tourethiopia.R

class RecyclerAdapter(private val captions: IntArray, private val imageid: IntArray) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var listener: Listener? = null

    interface Listener {
        fun onClick(position: Int)
    }

    class ViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView)

    override fun getItemCount(): Int {
        return captions.size
    }

    fun setListener(listener: Listener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(
            parent: ViewGroup, viewType: Int): ViewHolder {
        val cv = LayoutInflater.from(parent.context)
                .inflate(R.layout.cardview, parent, false) as CardView
        return ViewHolder(cv)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView = holder.cardView
        val imageView = cardView.findViewById<View>(R.id.info_image) as ImageView
        val drawable = ContextCompat.getDrawable(cardView.context, imageid[position])
        imageView.setImageDrawable(drawable)
        // imageView.setContentDescription(captions[position]);
        val textView = cardView.findViewById<View>(R.id.info_text) as TextView
        textView.setText(captions[position])
        cardView.setOnClickListener {
            listener?.onClick(position)
        }
    }

}