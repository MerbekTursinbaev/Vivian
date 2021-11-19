package com.example.instagram.retrofit.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.instagram.data.json.catagory.Catalog
import com.example.instagram.databinding.OrderDialogBinding
import com.example.instagram.retrofit.ui.order.basket.Basket


class OrderDialog(mContext: Context, var list: List<Catalog> ) : AlertDialog(mContext) {

    private lateinit var binding: OrderDialogBinding
    private val mAdapterDialog = DialogAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OrderDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mAdapterDialog.models = list
        binding.recyclerView.adapter = mAdapterDialog

        binding.btnOrder.setOnClickListener {

        }

    }
}