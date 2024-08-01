package com.example.ascendion

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    var TAG = "HomeActivity"
    lateinit var homeTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Log.d(TAG,"im home oncreate -- mem is being allocated")
        homeTextView = findViewById(R.id.tvHome)
       var dataReceived = intent.getStringExtra("akey")
        homeTextView.setText(dataReceived)


    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG,"im home onStart -visible")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"im home onResume -- woken")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"im home onPause - sleep")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"im home onStop -- hibernate")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"im home onDestroy -- purged")

    }

}