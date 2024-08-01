package com.example.ascendion

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var  nameEditText: EditText    //declaration
    lateinit var mainTextView: TextView

    var TAG = MainActivity::class.java.simpleName
//componentwillmount
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.etName)  //initialization
        mainTextView = findViewById(R.id.tvMain)
    Log.i(TAG,"im main oncreate")

}

    //componentdidmount
    override fun onStart() {
        super.onStart()
        Log.e(TAG,"im main onstart")

    }


    fun clickHandler(view: View) {
        //get the data from edittext
        var data = nameEditText.text.toString()
        //put it on the textview
        mainTextView.setText(data)
        var homeIntention = Intent(this,HomeActivity::class.java)
        homeIntention.putExtra("akey",data)
        Log.v(TAG,"im main clickHandler")

        startActivity(homeIntention)
    }

    fun launchHome(view: View) {
        var homeIntention = Intent(this,HomeActivity::class.java)
        startActivity(homeIntention)
        Log.w(TAG,"im main launchHome")

    }

    fun startDialer(view: View) {

        var dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543"))
        startActivity(dialIntent)
    }

    fun setAlarm(view: View) {
        createAlarm("ascendion",15,31)

    }


    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
       /// if (intent.resolveActivity(packageManager) != null) { checking if alarm clock exist on the ph
            startActivity(intent)
        //}
    }

}