package com.example.ascendion

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import com.example.ascendion.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : Activity() {
   // var count = 0

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel


    var TAG = MainActivity::class.java.simpleName
//componentwillmount
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.btnSome.setOnClickListener{
       //displaySnackBar()
      // count++
      // binding.tvMain.text = ""+count
   }


    Log.i(TAG,"im main oncreate")

}

    private fun displaySnackBar() {
        var view: ConstraintLayout = findViewById(R.id.clayout)
        Snackbar.make(this, view, " deleted email", Snackbar.LENGTH_SHORT)
            .setAction("undo", { Log.i(TAG, "undoing deletion") })
            .show()
    }

    //componentdidmount
    override fun onStart() {
        super.onStart()
        Log.e(TAG,"im main onstart")

    }


    fun clickHandler(view: View) {     //method header/signature
        //get the data from edittext
        var data = binding.etName.text.toString()
        //put it on the textview
        binding.tvMain.setText(data)
        var homeIntention = Intent(this,HomeActivity::class.java)
        homeIntention.putExtra("akey",data)
        Log.v(TAG,"im main clickHandler")
        add(10,20)
        startActivity(homeIntention)
       // throw NullPointerException("demo crash")
    }

    private fun add(i: Int, i1: Int) {

        repeat(2) {
            var c = i + i1
            var d = c * i + 10
        }

    }

    fun launchHome(view: View) {
        var homeIntention = Intent(this,HomeActivity::class.java)  //explicit intent
        startActivity(homeIntention)
        Log.w(TAG,"im main launchHome")

    }

    fun startDialer(view: View) {

        var dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543"))  //implicit intent
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