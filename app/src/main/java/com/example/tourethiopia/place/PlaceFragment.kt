package com.example.tourethiopia.place

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tourethiopia.R

class PlaceFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val placeRecycler = inflater.inflate(
                R.layout.fragment_place, container, false) as RecyclerView
        val placesname = IntArray(PlacesData.Companion.PLACES_DATA.size)
        for (i in placesname.indices) {
            placesname[i] = PlacesData.Companion.PLACES_DATA.get(i).name
        }
        val placesimageid = IntArray(PlacesData.Companion.PLACES_DATA.size)
        for (i in placesimageid.indices) {
            placesimageid[i] = PlacesData.Companion.PLACES_DATA.get(i).placesimagersourceid
        }
        val adapter = RecyclerAdapter(placesname, placesimageid)
        placeRecycler.adapter = adapter
        val layoutManager = GridLayoutManager(activity, 2)
        placeRecycler.layoutManager = layoutManager
        adapter.setListener(object : RecyclerAdapter.Listener {
            override fun onClick(position: Int) {
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.Companion.EXTRA_PLACES_ID, position)
                activity!!.startActivity(intent)
            }
        })

        return placeRecycler
    }
}