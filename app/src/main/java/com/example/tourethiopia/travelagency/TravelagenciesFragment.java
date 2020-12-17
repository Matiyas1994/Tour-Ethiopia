package com.example.tourethiopia.travelagency;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tourethiopia.R;
import com.example.tourethiopia.hotels.HotelDetailActivity;
import com.example.tourethiopia.hotels.HotelRecyclerAdapter;
import com.example.tourethiopia.hotels.HotelsData;


public class TravelagenciesFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView travelRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_travelagencies, container, false);

        int[] travellname=new int[TravelData.TRAVEL_DATA.length];
        for (int i=0;i<travellname.length;i++){
            travellname[i]=TravelData.TRAVEL_DATA[i].getName();
        }

        int[] hotelimageid= new int[TravelData.TRAVEL_DATA.length];
        for (int i=0;i<hotelimageid.length;i++) {
            hotelimageid[i] =TravelData.TRAVEL_DATA[i].getHotelimagersourceid();
        }

        float[] rating= new float[TravelData.TRAVEL_DATA.length];
        for (int i=0;i<rating.length;i++){
            rating[i]=TravelData.TRAVEL_DATA[i].getRating();
        }


        TravelRcyclerAdapter adapter = new TravelRcyclerAdapter(travellname,hotelimageid,rating);
        travelRecycler.setAdapter(adapter);
        //        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        travelRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        travelRecycler.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        adapter.setListener(new TravelRcyclerAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), TravelDetailActivity.class);
                intent.putExtra(TravelDetailActivity.EXTRA_TRAVEL_ID, position);
                getActivity().startActivity(intent);
            }
        });



        return travelRecycler;
    }
}