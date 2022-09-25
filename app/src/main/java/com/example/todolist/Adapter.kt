package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class Adapter(var data:List<Cardinfo>): RecyclerView.Adapter<Adapter.viewHolder>() {
    class viewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var title = itemView.title
        var description = itemView.description
        var layout = itemView.mylayout
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var itemView=LayoutInflater.from(parent.context).
                inflate(R.layout.view,parent,false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.title.text=data[position].title
        holder.description.text=data[position].description


    }

    override fun getItemCount(): Int {
       return data.size
    }


}