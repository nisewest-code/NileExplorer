package com.nileex.plorer.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nileex.plorer.R
import com.nileex.plorer.model.ModelItem

class AdapterRv(private val callback: (pos: Int)->Unit): RecyclerView.Adapter<HolderItem>() {
    private var list = mutableListOf<ModelItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderItem {
        return HolderItem(LayoutInflater.from(parent.context).inflate(R.layout.layout_holder_item, parent, false), callback)
    }

    override fun onBindViewHolder(holder: HolderItem, position: Int) {
        holder.updateView(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(nList: MutableList<ModelItem>){
        list = nList
        notifyDataSetChanged()
    }

    fun updateItem(pos: Int){
        notifyItemChanged(pos)
    }
}