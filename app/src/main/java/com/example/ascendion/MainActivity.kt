package com.example.ascendion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var  nameEditText: EditText    //declaration
    lateinit var mainTextView: TextView

//componentwillmount
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.etName)  //initialization
        mainTextView = findViewById(R.id.tvMain)
    }

    //componentdidmount
    override fun onStart() {
        super.onStart()
    }


    fun clickHandler(view: View) {
        //get the data from edittext
        var data = nameEditText.text.toString()
        //put it on the textview
        mainTextView.setText(data)
    }

    fun launchHome(view: View) {
        var homeIntention = Intent(this,HomeActivity::class.java)
        startActivity(homeIntention)
    }

}