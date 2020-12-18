package com.example.tourethiopia

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {
    var SPLASH_TIME = 4000 //This is 4 seconds
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        Handler().postDelayed({
            val i = Intent(this@FirstActivity, MainActivity::class.java)
            startActivity(i)

            // close this activity
            finish()
        }, SPLASH_TIME.toLong()) // wait for 4 seconds
    }
}