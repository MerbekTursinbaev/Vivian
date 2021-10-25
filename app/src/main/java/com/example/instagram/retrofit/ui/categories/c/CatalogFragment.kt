package com.example.instagram.retrofit.ui.categories.c

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.instagram.R
import com.example.instagram.data.resource.ResourceState
import com.example.instagram.databinding.FragmentCatalogBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CatalogFragment: Fragment(R.layout.fragment_catalog) {

    private lateinit var binding: FragmentCatalogBinding
    private val viewModel: CatalogViewModel by viewModel()
    private val args: CatalogFragmentArgs by navArgs()
    private val mAdapter = CatalogAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCatalogBinding.bind(view)
        binding.recyclerView.adapter = mAdapter


        viewModel.getCatalog(args.id)
        viewModel.getCatalog.observe(viewLifecycleOwner,{
            when(it.status) {
                ResourceState.LOADING-> {
                    binding.progressBar.isVisible = true
                }
                ResourceState.SUCCESS -> {
                    binding.progressBar.isVisible = false
                    mAdapter.models = it.data!!
                }
                ResourceState.ERROR -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })



    }
}