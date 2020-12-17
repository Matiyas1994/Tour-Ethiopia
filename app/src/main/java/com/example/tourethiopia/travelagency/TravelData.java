package com.example.tourethiopia.travelagency;

import com.example.tourethiopia.R;

public class TravelData {

    private int name;
    private int hotelimagersourceid;
    private float rating;

    public TravelData(int name, int hotelimagersourceid, float rating) {
        this.name = name;
        this.hotelimagersourceid = hotelimagersourceid;
        this.rating = rating;
    }

    public static final com.example.tourethiopia.travelagency.TravelData[] TRAVEL_DATA= {new com.example.tourethiopia.travelagency.TravelData(R.string.imagin_travellname,
            R.drawable.imagintravel, (float)4.5),
            new com.example.tourethiopia.travelagency.TravelData(R.string.welcom_travellname, R.drawable.welcometour,(float) 4),
            new com.example.tourethiopia.travelagency.TravelData(R.string.aman_travellname, R.drawable.amerantravel,(float) 3.5),
            new com.example.tourethiopia.travelagency.TravelData(R.string.base_travellname, R.drawable.basetravel,(float) 4),
            new com.example.tourethiopia.travelagency.TravelData(R.string.yema_travellname, R.drawable.yamatravel,(float) 4),
            new com.example.tourethiopia.travelagency.TravelData(R.string.ethio_travellname, R.drawable.ethiotravel,(float) 5),
            new com.example.tourethiopia.travelagency.TravelData(R.string.fklm_travellname, R.drawable.fklm,(float) 4.5),
            new com.example.tourethiopia.travelagency.TravelData(R.string.abba_travellname, R.drawable.abbatravel,(float) 4),

    };

    public int getName() {
        return name;
    }

    public int getHotelimagersourceid() {
        return hotelimagersourceid;
    }

    public float getRating() {
        return rating;
    }
}
