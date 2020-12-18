package com.example.tourethiopia.place

import com.example.tourethiopia.R

class PlacesData(//
        val name: Int, val placesimagersourceid: Int, //
        val desc: Int) {

    companion object {
        val PLACES_DATA = arrayOf(PlacesData(R.string.lalibela,
                R.drawable.lalibela, R.string.lalibela_description),
                PlacesData(R.string.unity_park, R.drawable.unity_park, R.string.unity_park_desc),
                PlacesData(R.string.axum_name, R.drawable.axum, R.string.axum_desc),
                PlacesData(R.string.dankil_name, R.drawable.denkel, R.string.dankil_desc),
                PlacesData(R.string.fasil_named, R.drawable.fasil, R.string.fasil_desc),
                PlacesData(R.string.bluenile_named, R.drawable.bluenile, R.string.bluenile_desc),
                PlacesData(R.string.ertale_name, R.drawable.ertale, R.string.ertale_desc),
                PlacesData(R.string.nechsar_named, R.drawable.nechsar, R.string.nechsar_desc))
    }

}