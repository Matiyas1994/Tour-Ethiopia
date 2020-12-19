package com.example.tourethiopia.hotels

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tourethiopia.R

class HotelFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val hotelRecycler = inflater.inflate(
                R.layout.fragment_hotel, container, false) as RecyclerView
        val hotelname = IntArray(HotelsData.Companion.HOTELS_DATA.size)
        for (i in hotelname.indices) {
            hotelname[i] = HotelsData.Companion.HOTELS_DATA.get(i).name
        }
        val hotelimageid = IntArray(HotelsData.Companion.HOTELS_DATA.size)
        for (i in hotelimageid.indices) {
            hotelimageid[i] = HotelsData.Companion.HOTELS_DATA.get(i).gethotelimagersourceid()
        }
        val rating = FloatArray(HotelsData.Companion.HOTELS_DATA.size)
        for (i in rating.indices) {
            rating[i] = HotelsData.Companion.HOTELS_DATA.get(i).rating
        }
        val adapter = HotelRecyclerAdapter(hotelname, hotelimageid, rating)
        hotelRecycler.adapter = adapter
        //        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        hotelRecycler.layoutManager = LinearLayoutManager(activity)
        hotelRecycler.addItemDecoration(DividerItemDecoration(activity, LinearLayoutManager.VERTICAL))
        adapter.setListener(object :HotelRecyclerAdapter.Listener{

          override  fun onClick(position: Int){
              val intent = Intent(activity, HotelDetailActivity::class.java)
              intent.putExtra(HotelDetailActivity.Companion.EXTRA_HOTELS_ID, position)
              activity!!.startActivity(intent)
          }
        })
        return hotelRecycler
    }
}