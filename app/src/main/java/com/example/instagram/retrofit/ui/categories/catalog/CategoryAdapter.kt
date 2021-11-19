package com.example.instagram.retrofit.ui.categories.catalog

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.R
import com.example.instagram.data.json.catagory.Category
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var models: List<Category> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(category: Category) {
            itemView.tvName.text = category.name
            itemView.tvDescription.text = category.description
            itemView.setOnClickListener {
                onClick.invoke(category.id)
            }
        }
    }

    private var onClick: (id: Int) -> Unit = {}
    fun setOnItemClickListener(onClick: (id: Int) -> Unit) {
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size

}