package com.example.instagram.retrofit.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.instagram.R
import com.example.instagram.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.tvCatalog.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_categoryFragment)
        }

        binding.apply {
            tvRegister.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_registerFragment)
            }

            tvOrder.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_orderFragment)
            }

        }
    }
}