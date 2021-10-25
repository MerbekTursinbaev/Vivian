package com.example.instagram.retrofit.ui.order.catalog

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagram.data.json.catagory.Catalog
import com.example.instagram.databinding.OrderItemBinding

class OrderCatalogAdapter: RecyclerView.Adapter<OrderCatalogAdapter.ViewHolder>() {

    var models : List<Catalog> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(private val binding: OrderItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val image = binding.tvImage

        fun populateModel(catalog: Catalog) {

            val url = catalog.image
            Glide.with(image)
                .load(url)
                .circleCrop()
                .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = OrderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size
}