package com.example.tourethiopia.hotels;

import com.example.tourethiopia.R;

public class HotelsData {

    private int name;
    private int hotelimagersourceid;
    private float rating;

    private int address;
    private int phonenumber;


    public HotelsData(int namestrsourceid, int hotelimagersourceid, float rating, int address, int phonenumber) {
        this.rating=rating;
        this.hotelimagersourceid = hotelimagersourceid;
        this.name = namestrsourceid;
        this.address = address;
        this.phonenumber = phonenumber;
    }
    public static final com.example.tourethiopia.hotels.HotelsData[] HOTELS_DATA= {new com.example.tourethiopia.hotels.HotelsData(R.string.lalibela,
            R.drawable.lalibela, (float)4.5,R.string.lalibela_hoteladrees,R.string.lalibela_hotelPhone),
            new com.example.tourethiopia.hotels.HotelsData(R.string.unity_park, R.drawable.unity_park,(float) 5,R.string.unity_hoteladrees,R.string.unity_hotelPhone)};

    public int getName() {
        return name;
    }

    public int gethotelimagersourceid() {
        return hotelimagersourceid;
    }

    public float getRating() {
        return rating;
    }
    public int getAddress() {
        return address;
    }

    public int getPhonenumber() {
        return phonenumber;
    }
}
