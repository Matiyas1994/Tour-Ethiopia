package com.example.tourethiopia.travelagency

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.tourethiopia.R
import com.example.tourethiopia.travelagency.TravelDetailActivity

class TravelDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_detail)
        val toolbar = findViewById<View>(R.id.toolbarid) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        val travelId = intent.extras!![EXTRA_TRAVEL_ID] as Int
        val travelName: Int = TravelData.Companion.TRAVEL_DATA.get(travelId).name
        val textView = findViewById<View>(R.id.travelinfo) as TextView
        textView.setText(R.string.registration)
    }

    fun onClickDone(view: View?) {
        val text: CharSequence = "Your Registration has been sent successfully "
        val duration = Snackbar.LENGTH_SHORT
        val snackbar = Snackbar.make(findViewById(R.id.framelayout), text, duration)
        snackbar.setAction("Undo") {
            val toast = Toast.makeText(this@TravelDetailActivity, "Undone!", Toast.LENGTH_SHORT)
            toast.show()
        }
        snackbar.show()
    }

    companion object {
        const val EXTRA_TRAVEL_ID = "travelId"
    }
}