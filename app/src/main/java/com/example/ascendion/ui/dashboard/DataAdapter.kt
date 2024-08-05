package com.example.ascendion.ui.dashboard

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ascendion.R
import com.example.ascendion.datastorage.Item

class DataAdapter(var data: List<Item>):RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

   var TAG = DataAdapter::class.java.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        Log.i(TAG,"raghu bringing row card")
        var rowPlank = LayoutInflater.from(parent.context).inflate(R.layout.row_card,parent,false)
        return DataViewHolder(rowPlank)

    }

    override fun getItemCount(): Int {
        Log.i(TAG,"jamitha is counting --"+data.size)
        return  data.size
    }

    override fun onBindViewHolder(naveenViewHolder: DataViewHolder, position: Int) {
        Log.i(TAG,"given by naveen , vignika is writing "+ data[position])
        naveenViewHolder.tvRowItem.text = data[position].itemName
    }

    class DataViewHolder(rowPlank: View):RecyclerView.ViewHolder(rowPlank) {
        var tvRowItem = itemView.findViewById<TextView>(R.id.tvRow)

        init {
            Log.i("DataAdapter","naveen got the row card bouhgt by raghu")
        }

    }
}