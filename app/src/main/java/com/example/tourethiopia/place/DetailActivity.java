package com.example.tourethiopia.place;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tourethiopia.R;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_PLACES_ID = "placeId";
    public static final String EXTRA_lang_ID="lang";

   // private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //String lang = (String)getIntent().getExtras().get(EXTRA_lang_ID);
       // setLocale(lang);
        //loadlocale();
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        int placeId = (Integer)getIntent().getExtras().get(EXTRA_PLACES_ID);
        int placeName = PlacesData.PLACES_DATA[placeId].getName();
        int placeDesc= PlacesData.PLACES_DATA[placeId].getDesc();
        TextView textView1 = (TextView)findViewById(R.id.placedescTitle);
        textView1.setText(placeName);
        TextView textView2 = (TextView)findViewById(R.id.placedetails);
        textView2.setText(placeDesc);

        int placeImage = PlacesData.PLACES_DATA[placeId].getPlacesimagersourceid();
        ImageView imageView = (ImageView)findViewById(R.id.desc_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, placeImage));
        //imageView.setContentDescription(placeName);
    }

//    private  void setLocale(String lang) {
//        Locale locale = new Locale(lang);
//        Locale.setDefault(locale);
//        Configuration config= new Configuration();
//        config.locale=locale;
//
//        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
//
//        SharedPreferences.Editor editor= getSharedPreferences("settings",MODE_PRIVATE).edit();
//        editor.putString("My_Lang",lang);
//        editor.apply();
//
//    }
//
//    public  void loadlocale(){
//        SharedPreferences pref= getSharedPreferences("settings", Activity.MODE_PRIVATE);
//        String language= pref.getString("My_Lang","");
//        setLocale(language);
//    }
}