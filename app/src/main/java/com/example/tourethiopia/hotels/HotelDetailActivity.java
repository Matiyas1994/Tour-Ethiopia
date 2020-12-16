package com.example.tourethiopia.hotels;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tourethiopia.R;
import com.example.tourethiopia.place.PlacesData;

public class HotelDetailActivity extends AppCompatActivity {

    public static final String EXTRA_HOTELS_ID="hotelId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int hotelId = (Integer)getIntent().getExtras().get(EXTRA_HOTELS_ID);
        int hotelName = HotelsData.HOTELS_DATA[hotelId].getName();
        int addressDesc= HotelsData.HOTELS_DATA[hotelId].getAddress();
        int hotelPhone = HotelsData.HOTELS_DATA[hotelId].getPhonenumber();
        int hotelImage = HotelsData.HOTELS_DATA[hotelId].gethotelimagersourceid();

        TextView textView1 = (TextView)findViewById(R.id.hotel_text);
        textView1.setText(hotelName);
        TextView textView2 = (TextView)findViewById(R.id.hoteladdress);
        textView2.setText(addressDesc);
        TextView textView3 = (TextView)findViewById(R.id.hotel_phonenumber);
        textView3.setText(hotelPhone);
        ImageView imageView = (ImageView)findViewById(R.id.hoteldetail_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, hotelImage));
    }
}