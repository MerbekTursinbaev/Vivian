package com.example.instagram.retrofit.ui.categories.c

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagram.data.json.catagory.Catalog
import com.example.instagram.databinding.CatalogItemBinding

class CatalogAdapter : RecyclerView.Adapter<CatalogAdapter.ViewHolder>() {

    var models : List<Catalog> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(private val binding: CatalogItemBinding  ) : RecyclerView.ViewHolder(binding.root) {

       private val image = binding.imageView

        fun populateModel(catalog: Catalog) {

            binding.tvPoint.text = catalog.point.toString()
            binding.tvName.text = catalog.name

            val url = catalog.image
            Glide.with(image)
                .load(url)
                .circleCrop()
                .into(image)

            itemView.setOnClickListener {
                onClick.invoke(catalog.id)
            }
        }
    }

    private var onClick: (id: Int) -> Unit = {}
    fun setOnItemClickListener(onClick: (id: Int) -> Unit) {
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CatalogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size
}