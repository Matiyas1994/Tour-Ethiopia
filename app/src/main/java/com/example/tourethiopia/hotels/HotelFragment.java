package com.example.tourethiopia.hotels;

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


public class HotelFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        RecyclerView hotelRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_hotel, container, false);

         int[] hotelname=new int[HotelsData.HOTELS_DATA.length];
               for (int i=0;i<hotelname.length;i++){
                    hotelname[i]=HotelsData.HOTELS_DATA[i].getName();
                }

                int[] hotelimageid= new int[HotelsData.HOTELS_DATA.length];
                for (int i=0;i<hotelimageid.length;i++) {
                    hotelimageid[i] = HotelsData.HOTELS_DATA[i].gethotelimagersourceid();
                }

               float[] rating= new float[HotelsData.HOTELS_DATA.length];
                for (int i=0;i<rating.length;i++){
                    rating[i]=HotelsData.HOTELS_DATA[i].getRating();
                }

                HotelRecyclerAdapter adapter = new HotelRecyclerAdapter(hotelname,hotelimageid,rating);
                hotelRecycler.setAdapter(adapter);
        //        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
               hotelRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        hotelRecycler.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

            adapter.setListener(new HotelRecyclerAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), HotelDetailActivity.class);
                intent.putExtra(HotelDetailActivity.EXTRA_HOTELS_ID, position);
                getActivity().startActivity(intent);
            }
        });


        return hotelRecycler;
    }
}