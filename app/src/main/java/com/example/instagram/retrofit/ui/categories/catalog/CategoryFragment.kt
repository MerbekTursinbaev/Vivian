package com.example.instagram.retrofit.ui.categories.catalog

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.instagram.R
import com.example.instagram.data.resource.ResourceState
import com.example.instagram.databinding.CategoryFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryFragment : Fragment(R.layout.category_fragment) {

    private lateinit var binding: CategoryFragmentBinding
    private var mAdapter = CategoryAdapter()
    private val viewModel: CategoryViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = CategoryFragmentBinding.bind(view)

        binding.recyclerViewCategory.adapter = mAdapter

        viewModel.getCategory()

        viewModel.getCategory.observe(viewLifecycleOwner, {
            when (it.status) {
                ResourceState.SUCCESS -> {
                    mAdapter.models = it.data!!
                }
                ResourceState.ERROR -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

        mAdapter.setOnItemClickListener {id: Int ->
            val action = CategoryFragmentDirections.actionCategoryFragmentToCatalogFragment(id)
            findNavController().navigate(action)
        }
    }
}