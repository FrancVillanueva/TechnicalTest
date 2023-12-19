package com.example.technicaltest.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.technicaltest.R
import com.example.technicaltest.ui.model.Result

class FactsAdapter(private var results: List<Result>) : RecyclerView.Adapter<FactsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_fact, parent, false)
        return FactsViewHolder(itemView)
    }

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: FactsViewHolder, position: Int) {
        val item = results[position]
        holder.bind(item)
    }

    fun setData(results: List<Result>) {
        this.results = results
        notifyDataSetChanged()
    }
}