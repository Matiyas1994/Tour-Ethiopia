package com.example.tourethiopia.place;

import com.example.tourethiopia.R;

public class PlacesData {
    //
        private int name;
        private int placesimagersourceid;
        private int desc;

        public PlacesData(int namestrsourceid, int placesimagersourceid,int desc) {
           this.desc=desc;
            this.placesimagersourceid = placesimagersourceid;
          this.name = namestrsourceid;
        }
        public static final com.example.tourethiopia.place.PlacesData[] PLACES_DATA= {new com.example.tourethiopia.place.PlacesData(R.string.lalibela,
                R.drawable.lalibela,R.string.lalibela_description),
                new com.example.tourethiopia.place.PlacesData(R.string.unity_park, R.drawable.unity_park,R.string.unity_park_desc)};

        public int getName() {
            return name;
        }

        public int getPlacesimagersourceid() {
            return placesimagersourceid;
        }

    public int getDesc() {
        return desc;
    }
//
}
