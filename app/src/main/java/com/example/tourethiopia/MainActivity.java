package com.example.tourethiopia;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tourethiopia.hotels.HotelFragment;
import com.example.tourethiopia.place.DetailActivity;
import com.example.tourethiopia.place.PlaceFragment;
import com.example.tourethiopia.travelagency.TravelagenciesFragment;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadlocale();
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarid);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        SectionsPagerAdapter pagerAdapter= new SectionsPagerAdapter(getSupportFragmentManager());
        android.support.v4.view.ViewPager viewPager=(ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);

        //Attach the ViewPager to the TabLayout
        android.support.design.widget.TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuItem menuItem= menu.findItem(R.id.action_shareid);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setshareActionIntent("Want to Know more about Ethiopia?");

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
//                Intent intent = new Intent(this, SettingActivity.class);
//                startActivity(intent);
                showchangeLangugeDialog();

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

    private void showchangeLangugeDialog() {
        final String[] listitems={"አማርኛ","English"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Choose Language...");
        mBuilder.setSingleChoiceItems(listitems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i==0){
                    setLocale("am");
//                    Intent intent2 = new Intent(MainActivity.this, DetailActivity.class);
//                    intent2.putExtra(DetailActivity.EXTRA_lang_ID,"am");
//                    startActivity(intent2);
                    recreate();

                }


                else if (i==1){
                    setLocale("en");
//                    Intent intent2 = new Intent(MainActivity.this, DetailActivity.class);
//                    intent2.putExtra(DetailActivity.EXTRA_lang_ID,"en");
//                    startActivity(intent2);
                    recreate();
                }

                dialogInterface.dismiss();

            }
        });

        AlertDialog mDialog= mBuilder.create();
        mDialog.show();
    }

    private  void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config= new Configuration();
        config.locale=locale;


        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor= getSharedPreferences("settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();

    }

    public  void loadlocale(){
        SharedPreferences pref= getSharedPreferences("settings", Activity.MODE_PRIVATE);
        String language= pref.getString("My_Lang","");
        setLocale(language);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        String lang =Locale.getDefault().toString();
//        Intent intent2 = new Intent(MainActivity.this, DetailActivity.class);
//        intent2.putExtra(DetailActivity.EXTRA_lang_ID,lang);
//        startActivity(intent2);
//
//    }
}