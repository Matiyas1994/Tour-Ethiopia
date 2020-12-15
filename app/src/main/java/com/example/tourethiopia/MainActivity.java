package com.example.tourethiopia;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);


        SectionsPagerAdapter pagerAdapter= new SectionsPagerAdapter(getSupportFragmentManager());
        android.support.v4.view.ViewPager viewPager=(ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);

        //Attach the ViewPager to the TabLayout
        android.support.design.widget.TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_orderid:
                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void setshareActionIntent(String text){

        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,text);
        shareActionProvider.setShareIntent(intent);
    }


    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i){
                case 0:
                    return new PlaceFragment();
                case 1:
                    return new HotelFragment();
                case 2:
                    return new TravelagenciesFragment();
                case 3:
                    return new MapFragment();
            }
            return null;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getText(R.string.place_tab);
                case 1:
                    return getResources().getText(R.string.hotel_tab);
                case 2:
                    return getResources().getText(R.string.travelagencies_tab);
                case 3:
                    return getResources().getText(R.string.map_tab);
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

}