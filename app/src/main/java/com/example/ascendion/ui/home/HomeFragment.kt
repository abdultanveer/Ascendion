package com.example.ascendion.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ascendion.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    //var count = 0
    lateinit var homeViewModel: HomeViewModel


    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.tvHome.text = ""+ homeViewModel.count

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onStart() {
        super.onStart()
        binding.btnInc.setOnClickListener {
            homeViewModel.incrementCount()
            binding.tvHome.text = ""+homeViewModel.count

           // count++
           // binding.tvHome.text = ""+count
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}