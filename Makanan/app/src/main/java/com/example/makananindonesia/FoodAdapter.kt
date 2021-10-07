package com.example.makananindonesia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FoodAdapter(val listFood: ArrayList<Foods>) : RecyclerView.Adapter<FoodAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_food)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_foods, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listFood.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val food = listFood[position]
        Glide.with(holder.itemView.context)
            .load(food.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = food.name
        holder.tvDetail.text = food.detail
    }

}