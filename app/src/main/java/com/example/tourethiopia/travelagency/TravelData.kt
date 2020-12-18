package com.example.tourethiopia.travelagency

import com.example.tourethiopia.R

class TravelData(val name: Int, val hotelimagersourceid: Int, val rating: Float) {

    companion object {
        val TRAVEL_DATA = arrayOf(TravelData(R.string.imagin_travellname,
                R.drawable.imagintravel, 4.5.toFloat()),
                TravelData(R.string.welcom_travellname, R.drawable.welcometour, 4.toFloat()),
                TravelData(R.string.aman_travellname, R.drawable.amerantravel, 3.5.toFloat()),
                TravelData(R.string.base_travellname, R.drawable.basetravel, 4.toFloat()),
                TravelData(R.string.yema_travellname, R.drawable.yamatravel, 4.toFloat()),
                TravelData(R.string.ethio_travellname, R.drawable.ethiotravel, 5.toFloat()),
                TravelData(R.string.fklm_travellname, R.drawable.fklm, 4.5.toFloat()),
                TravelData(R.string.abba_travellname, R.drawable.abbatravel, 4.toFloat()))
    }

}