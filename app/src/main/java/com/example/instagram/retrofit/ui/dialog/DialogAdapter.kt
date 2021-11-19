package com.example.instagram.retrofit.ui.dialog

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.data.json.catagory.Catalog
import com.example.instagram.databinding.OrderDialogItemBinding

class DialogAdapter : RecyclerView.Adapter<DialogAdapter.ViewHolder>() {

    var models: List<Catalog> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(private val binding: OrderDialogItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun populateModel(catalog: Catalog) {
            binding.tvName.text = catalog.name
            binding.tvCount.text = catalog.count.toString()
            binding.tvSum.text = "${catalog.count*catalog.price}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            OrderDialogItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size
}