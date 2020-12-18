package com.example.tourethiopia.hotels

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.tourethiopia.R

class HotelDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_detail)
        val toolbar = findViewById<View>(R.id.toolbarid) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        val hotelId = intent.extras!![EXTRA_HOTELS_ID] as Int
        val hotelName: Int = HotelsData.Companion.HOTELS_DATA.get(hotelId).name
        val addressDesc: Int = HotelsData.Companion.HOTELS_DATA.get(hotelId).address
        val hotelPhone: Int = HotelsData.Companion.HOTELS_DATA.get(hotelId).phonenumber
        val hotelImage: Int = HotelsData.Companion.HOTELS_DATA.get(hotelId).gethotelimagersourceid()
        val textView1 = findViewById<View>(R.id.hotel_text) as TextView
        textView1.setText(hotelName)
        val textView2 = findViewById<View>(R.id.hoteladdress) as TextView
        textView2.setText(addressDesc)
        val textView3 = findViewById<View>(R.id.hotel_phonenumber) as TextView
        textView3.setText(hotelPhone)
        val imageView = findViewById<View>(R.id.hoteldetail_image) as ImageView
        imageView.setImageDrawable(ContextCompat.getDrawable(this, hotelImage))
    }

    companion object {
        const val EXTRA_HOTELS_ID = "hotelId"
    }
}