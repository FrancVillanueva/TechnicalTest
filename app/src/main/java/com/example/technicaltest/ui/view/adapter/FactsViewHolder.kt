package com.example.technicaltest.ui.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.technicaltest.databinding.ItemFactBinding
import com.example.technicaltest.ui.model.Result

class FactsViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val _binding =ItemFactBinding.bind(view)

    fun bind(result: Result) {
        _binding.tvId.text = result._id
        _binding.tvName.text = result.fact
        _binding.tvOrg.text = result.operations
    }
}