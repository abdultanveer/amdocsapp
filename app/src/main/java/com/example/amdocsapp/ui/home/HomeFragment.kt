package com.example.amdocsapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.amdocsapp.R
import com.example.amdocsapp.databinding.FragmentHomeBinding
import com.example.amdocsapp.network.MarsPhoto

class HomeFragment : Fragment() {

  lateinit  var homeViewModel:HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    var marsPhoto = MarsPhoto("123","https://someurl.com")

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

       // _binding = FragmentHomeBinding.inflate(inflater, container, false)
         _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
         binding.mphoto = marsPhoto
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
           // binding.mphoto.imgSrc = it
            binding.imageView.load(it)
        }
        return root
    }

    override fun onStart() {
        super.onStart()
        binding.btnDash.setOnClickListener {
            homeViewModel.getMarsPhotos()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}