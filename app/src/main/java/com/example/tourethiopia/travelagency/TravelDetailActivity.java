package com.example.tourethiopia.travelagency;

import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tourethiopia.R;
import com.example.tourethiopia.hotels.HotelsData;

public class TravelDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TRAVEL_ID="travelId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);
        ActionBar actionBar= getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);


        int travelId = (Integer)getIntent().getExtras().get(EXTRA_TRAVEL_ID);
        int travelName = TravelData.TRAVEL_DATA[travelId].getName();

        TextView textView = (TextView)findViewById(R.id.travelinfo);
        textView.setText(R.string.registration);

    }

    public void onClickDone(View view) {
        CharSequence text = "Your Registration has been sent successfully ";
        int duration = Snackbar.LENGTH_SHORT;
        Snackbar snackbar = Snackbar.make(findViewById(R.id.framelayout), text, duration);
        snackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(TravelDetailActivity.this, "Undone!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        snackbar.show();
    }
}