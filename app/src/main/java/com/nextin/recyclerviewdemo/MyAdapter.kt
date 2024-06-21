package com.nextin.recyclerviewdemo

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val context: Activity, private val userArray: ArrayList<News>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        lateinit var myListener: OnItemClickListener

        interface OnItemClickListener{
            fun onItemSelecting(position: Int)
        }

        fun setOnItemClickListener(listener: OnItemClickListener){
            myListener = listener
        }

        class MyViewHolder(itemView : View, listener: OnItemClickListener) :RecyclerView.ViewHolder(itemView) {
            val news = itemView.findViewById<TextView>(R.id.NewsHeading)
            val newsImage = itemView.findViewById<ImageView>(R.id.newsImage)

            init {
                itemView.setOnClickListener {
                    listener.onItemSelecting(adapterPosition)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(view,myListener)
    }

    override fun getItemCount(): Int {
      return userArray.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.news.text= userArray[position].newsHedind
        holder.newsImage.setImageResource(userArray[position].newsImage)
    }
}
