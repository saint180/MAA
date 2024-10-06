package com.example.hello

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProBonoLawyersAdapter(private val lawyersList: List<String>) :
    RecyclerView.Adapter<ProBonoLawyersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.lawyerName.text = lawyersList[position]
    }

    override fun getItemCount(): Int {
        return lawyersList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val lawyerName: TextView = view.findViewById(android.R.id.text1)
    }
}
