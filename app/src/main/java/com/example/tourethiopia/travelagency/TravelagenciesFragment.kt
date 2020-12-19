package com.example.tourethiopia.travelagency

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
import com.example.tourethiopia.place.DetailActivity
import com.example.tourethiopia.place.RecyclerAdapter

class TravelagenciesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val travelRecycler = inflater.inflate(R.layout.fragment_travelagencies, container, false) as RecyclerView
         val travellname = IntArray(TravelData.Companion.TRAVEL_DATA.size)
        for (i in travellname.indices) {
            travellname[i] = TravelData.Companion.TRAVEL_DATA.get(i).name
        }
        val hotelimageid = IntArray(TravelData.Companion.TRAVEL_DATA.size)
        for (i in hotelimageid.indices) {
            hotelimageid[i] = TravelData.Companion.TRAVEL_DATA.get(i).hotelimagersourceid
        }
        val rating = FloatArray(TravelData.Companion.TRAVEL_DATA.size)
        for (i in rating.indices) {
            rating[i] = TravelData.Companion.TRAVEL_DATA.get(i).rating
        }
         val adapter = TravelRcyclerAdapter(travellname, hotelimageid, rating)
        travelRecycler.adapter = adapter
        //        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        travelRecycler.layoutManager = LinearLayoutManager(activity)
        travelRecycler.addItemDecoration(DividerItemDecoration(activity, LinearLayoutManager.VERTICAL))
        adapter.setListener(object : TravelRcyclerAdapter.Listener {
            override fun onClick(position: Int) {
                val intent = Intent(activity, TravelDetailActivity::class.java)
                intent.putExtra(TravelDetailActivity.Companion.EXTRA_TRAVEL_ID, position)
                activity!!.startActivity(intent)
            }
        })

        return travelRecycler
    }
}