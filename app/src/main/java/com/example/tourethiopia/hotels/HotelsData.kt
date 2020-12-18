package com.example.tourethiopia.hotels

import com.example.tourethiopia.R

data class HotelsData(val name: Int, private val hotelimagersourceid: Int, val rating: Float, val address: Int, val phonenumber: Int) {

    fun gethotelimagersourceid(): Int {
        return hotelimagersourceid
    }



    companion object {
        val HOTELS_DATA = arrayOf(HotelsData(R.string.skyligt_hotelname,
                R.drawable.skaylight, 5.toFloat(), R.string.skyligt_hoteladrees, R.string.skyligt_hotelPhone),
                HotelsData(R.string.golden_hotelname, R.drawable.goldenhotel, 5.toFloat(), R.string.goldenhoteladrees, R.string.golden_hotelPhone),
                HotelsData(R.string.hailegondar_hotelname, R.drawable.haileresortgondar, 3.5.toFloat(), R.string.hailegondar_hoteladrees, R.string.hailegondar_hotelPhone),
                HotelsData(R.string.unison_hotelname, R.drawable.unison, 4.toFloat(), R.string.unison_hoteladrees, R.string.unison_hotelPhone),
                HotelsData(R.string.planet_hotelname, R.drawable.mekeleplanet, 4.5.toFloat(), R.string.planet_hoteladrees, R.string.planet_hotelPhone),
                HotelsData(R.string.hailehawasa_hotelname, R.drawable.hailehawasa, 4.toFloat(), R.string.hailehawasa_hoteladrees, R.string.hailehawasa_hotelPhone)
        )
    }

}