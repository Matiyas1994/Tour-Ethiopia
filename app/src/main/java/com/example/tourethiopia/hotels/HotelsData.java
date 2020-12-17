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
    public static final com.example.tourethiopia.hotels.HotelsData[] HOTELS_DATA= {new com.example.tourethiopia.hotels.HotelsData(R.string.skyligt_hotelname,
            R.drawable.skaylight, (float)5,R.string.skyligt_hoteladrees,R.string.skyligt_hotelPhone),
            new com.example.tourethiopia.hotels.HotelsData(R.string.unity_park, R.drawable.unity_park,(float) 5,R.string.unity_hoteladrees,R.string.unity_hotelPhone),
            new com.example.tourethiopia.hotels.HotelsData(R.string.golden_hotelname, R.drawable.goldenhotel,(float) 5,R.string.goldenhoteladrees,R.string.golden_hotelPhone),
            new com.example.tourethiopia.hotels.HotelsData(R.string.hailegondar_hotelname, R.drawable.haileresortgondar,(float) 3.5,R.string.hailegondar_hoteladrees,R.string.hailegondar_hotelPhone),
            new com.example.tourethiopia.hotels.HotelsData(R.string.unison_hotelname, R.drawable.unison,(float) 4,R.string.unison_hoteladrees,R.string.unison_hotelPhone),
            new com.example.tourethiopia.hotels.HotelsData(R.string.planet_hotelname, R.drawable.mekeleplanet,(float) 4.5,R.string.planet_hoteladrees,R.string.planet_hotelPhone),
            new com.example.tourethiopia.hotels.HotelsData(R.string.hailehawasa_hotelname, R.drawable.hailehawasa,(float) 4,R.string.hailehawasa_hoteladrees,R.string.hailehawasa_hotelPhone)
    };

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
