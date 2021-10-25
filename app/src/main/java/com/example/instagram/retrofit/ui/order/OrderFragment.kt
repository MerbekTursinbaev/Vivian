package com.example.instagram.retrofit.ui.order

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.instagram.R
import com.example.instagram.data.resource.ResourceState
import com.example.instagram.databinding.FragmentOrderBinding
import com.example.instagram.retrofit.ui.order.catalog.OrderCatalogAdapter
import com.example.instagram.retrofit.ui.order.catalog.OrderCatalogViewModel
import com.example.instagram.retrofit.ui.order.category.OrderCategoryAdapter
import com.example.instagram.retrofit.ui.order.category.OrderCategoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrderFragment : Fragment(R.layout.fragment_order) {

    private lateinit var binding: FragmentOrderBinding

    private val viewModelCatalog: OrderCatalogViewModel by viewModel()
    private val viewModelCategory: OrderCategoryViewModel by viewModel()

    private val mAdapterCatalog = OrderCatalogAdapter()
    private var mAdapterCategory = OrderCategoryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrderBinding.bind(view)

        binding.recyclerViewHorizontal.adapter = mAdapterCategory
        binding.recyclerViewVertical.adapter = mAdapterCatalog

        viewModelCatalog.getCatalog(1)
        mAdapterCategory.setOnItemClickListener {
            viewModelCatalog.getCatalog(it)
        }

        viewModelCategory.getCategory()

        viewModelCategory.getCategoryOrder.observe(viewLifecycleOwner, {
            when (it.status) {
                ResourceState.LOADING -> {
                    binding.progressBar.isVisible = true
                }
                ResourceState.SUCCESS -> {
                    binding.progressBar.isVisible = false
                    mAdapterCategory.models = it.data!!
                }
                ResourceState.ERROR -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModelCatalog.getCatalogOrder.observe(viewLifecycleOwner,{
            when(it.status) {
                ResourceState.LOADING-> {
                    binding.progressBar.isVisible = true
                }
                ResourceState.SUCCESS -> {
                    binding.progressBar.isVisible = false
                    mAdapterCatalog.models = it.data!!
                }
                ResourceState.ERROR -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}