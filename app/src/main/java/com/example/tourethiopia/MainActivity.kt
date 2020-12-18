package com.example.tourethiopia

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.MenuItemCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.ShareActionProvider
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.tourethiopia.MainActivity
import com.example.tourethiopia.hotels.HotelFragment
import com.example.tourethiopia.place.PlaceFragment
import com.example.tourethiopia.travelagency.TravelagenciesFragment
import java.util.*

class MainActivity : AppCompatActivity() {
    private var shareActionProvider: ShareActionProvider? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadlocale()
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbarid) as Toolbar
        toolbar.title = resources.getString(R.string.app_name)
        setSupportActionBar(toolbar)
        val pagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        val viewPager = findViewById<View>(R.id.pager) as ViewPager
        viewPager.adapter = pagerAdapter

        //Attach the ViewPager to the TabLayout
        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val menuItem = menu.findItem(R.id.action_shareid)
        shareActionProvider = MenuItemCompat.getActionProvider(menuItem) as ShareActionProvider
        setshareActionIntent("Want to Know more about Ethiopia?")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_setting -> {
                //                Intent intent = new Intent(this, SettingActivity.class);
//                startActivity(intent);
                showchangeLangugeDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun setshareActionIntent(text: String?) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, text)
        shareActionProvider!!.setShareIntent(intent)
    }

    private inner class SectionsPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
        override fun getItem(i: Int): Fragment? {
            when (i) {
                0 -> return PlaceFragment()
                1 -> return HotelFragment()
                2 -> return TravelagenciesFragment()
                3 -> return MapFragment()
            }
            return null
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return resources.getText(R.string.place_tab)
                1 -> return resources.getText(R.string.hotel_tab)
                2 -> return resources.getText(R.string.travelagencies_tab)
                3 -> return resources.getText(R.string.map_tab)
            }
            return null
        }

        override fun getCount(): Int {
            return 4
        }
    }

    private fun showchangeLangugeDialog() {
        val listitems = arrayOf("አማርኛ", "English")
        val mBuilder = AlertDialog.Builder(this@MainActivity)
        mBuilder.setTitle("Choose Language...")
        mBuilder.setSingleChoiceItems(listitems, -1) { dialogInterface, i ->
            if (i == 0) {
                setLocale("am")
                //                    Intent intent2 = new Intent(MainActivity.this, DetailActivity.class);
//                    intent2.putExtra(DetailActivity.EXTRA_lang_ID,"am");
//                    startActivity(intent2);
                recreate()
            } else if (i == 1) {
                setLocale("en")
                //                    Intent intent2 = new Intent(MainActivity.this, DetailActivity.class);
//                    intent2.putExtra(DetailActivity.EXTRA_lang_ID,"en");
//                    startActivity(intent2);
                recreate()
            }
            dialogInterface.dismiss()
        }
        val mDialog = mBuilder.create()
        mDialog.show()
    }

    private fun setLocale(lang: String?) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        val editor = getSharedPreferences("settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", lang)
        editor.apply()
    }

    fun loadlocale() {
        val pref = getSharedPreferences("settings", Activity.MODE_PRIVATE)
        val language = pref.getString("My_Lang", "")
        setLocale(language)
    } //    @Override
    //    protected void onResume() {
    //        super.onResume();
    //        String lang =Locale.getDefault().toString();
    //        Intent intent2 = new Intent(MainActivity.this, DetailActivity.class);
    //        intent2.putExtra(DetailActivity.EXTRA_lang_ID,lang);
    //        startActivity(intent2);
    //
    //    }
}