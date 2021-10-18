package com.martynov.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    var list = mutableListOf< Pair<Post,Repost>>()

    fun addElement(newList: List<Pair<Post,Repost>>){
        list.addAll(newList)
        notifyDataSetChanged()
    }
    fun removeElementPoPost(post:Post){
        val index = list.indexOfFirst { it.first.text == post.text }
        if(index != -1){
            list.removeAt(index)
            notifyItemChanged(index)
        }

    }
    fun add(pair : Pair<Post,Repost>){
        list.add(pair)
        notifyDataSetChanged()
    }

    class PostViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bind(pair :Pair<Post,Repost>){
            val text = view.findViewById<TextView>(R.id.textView)
            val textTwo = view.findViewById<TextView>(R.id.textView2)
            text.text = pair.first.text
            textTwo.text = pair.second.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.post_card, parent, false))

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
       holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}