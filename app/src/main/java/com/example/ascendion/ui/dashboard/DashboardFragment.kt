package com.example.ascendion.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ascendion.databinding.FragmentDashboardBinding
import com.example.ascendion.datastorage.ItemDao
import com.example.ascendion.datastorage.ItemRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    var data = arrayOf("india","hindi","tiger","himalaya","india","hindi","tiger","himalaya",
        "india","hindi","tiger","himalaya","india","hindi","tiger","himalaya",
        "india","hindi","tiger","himalaya","india","hindi","tiger","himalaya",
        "india","hindi","tiger","himalaya","india","hindi","tiger","himalaya",
        "india","hindi","tiger","himalaya","india","hindi","tiger","himalaya",
        "india","hindi","tiger","himalaya","india","hindi","tiger","himalaya",
        "india","hindi","tiger","himalaya","india","hindi","tiger","himalaya",
        )

    lateinit var dao: ItemDao

//INSERT INTO item(id,name,price,quantity) values('2','grocery',22.2,22)
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var  database = ItemRoomDatabase.getDatabase(requireActivity().applicationContext)
        dao = database.itemDao()
        binding.recyclerview.layoutManager = LinearLayoutManager(activity)

        //put the plug into the adapter
        GlobalScope.launch(Dispatchers.Main) {
            var data = dao.getItems().first()
           // var dataAdapter = DataAdapter(data)
          //  binding.recyclerview.adapter = dataAdapter


        }



        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}