package com.example.tourethiopia.place;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tourethiopia.R;


public class PlaceFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        RecyclerView placeRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_place, container, false);
        int[] placesname=new int[PlacesData.PLACES_DATA.length];
        for (int i=0;i<placesname.length;i++){
            placesname[i]=PlacesData.PLACES_DATA[i].getName();

        }
        int[] placesimageid= new int[PlacesData.PLACES_DATA.length];
        for (int i=0;i<placesimageid.length;i++){
            placesimageid[i]=PlacesData.PLACES_DATA[i].getPlacesimagersourceid();

        }
        RecyclerAdapter adapter = new RecyclerAdapter(placesname,placesimageid);
        placeRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        placeRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new RecyclerAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_PLACES_ID, position);
                getActivity().startActivity(intent);
            }
        });
        return placeRecycler;
    }
}