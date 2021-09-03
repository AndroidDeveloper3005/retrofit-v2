package com.himel.androiddeveloper3005.git.retrofit_v2.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.recyclerview.widget.RecyclerView
import com.himel.androiddeveloper3005.git.retrofit_v2.R
import com.himel.androiddeveloper3005.git.retrofit_v2.model.Post
import kotlinx.android.synthetic.main.item_layout.view.*

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var myList = emptyList<Post>()

     class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.user_id_txt.text = myList[position].myUserID.toString()
        holder.itemView.id_txt.text = myList[position].id.toString()
        holder.itemView.title_txt.text = myList[position].title
        holder.itemView.body_txt.text = myList[position].body
        holder.itemView.setOnClickListener{
            Log.d("click_response",myList[position].id.toString())

        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<Post>){
        myList = newList
        notifyDataSetChanged()
    }

}