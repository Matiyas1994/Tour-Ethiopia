package com.example.tourethiopia.place

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.tourethiopia.R

class DetailActivity : AppCompatActivity() {
    // private ImageView imageView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //String lang = (String)getIntent().getExtras().get(EXTRA_lang_ID);
        // setLocale(lang);
        //loadlocale();
        setContentView(R.layout.activity_detail)
        val toolbar = findViewById<View>(R.id.toolbarid) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        val placeId = intent.extras!![EXTRA_PLACES_ID] as Int
        val placeName: Int = PlacesData.Companion.PLACES_DATA.get(placeId).name
        val placeDesc: Int = PlacesData.Companion.PLACES_DATA.get(placeId).desc
        val textView1 = findViewById<View>(R.id.placedescTitle) as TextView
        textView1.setText(placeName)
        val textView2 = findViewById<View>(R.id.placedetails) as TextView
        textView2.setText(placeDesc)
        val placeImage: Int = PlacesData.Companion.PLACES_DATA.get(placeId).placesimagersourceid
        val imageView = findViewById<View>(R.id.desc_image) as ImageView
        imageView.setImageDrawable(ContextCompat.getDrawable(this, placeImage))
        //imageView.setContentDescription(placeName);
    } //    private  void setLocale(String lang) {

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
    companion object {
        const val EXTRA_PLACES_ID = "placeId"
        const val EXTRA_lang_ID = "lang"
    }
}