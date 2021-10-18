package com.martynov.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val myAdapter  = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val post = Post("111")
        val repost = Repost("222")
        val list = mutableListOf<Pair<Post,Repost>>()
        for(i in 0..15){
            list.add(Pair(Post("post $i"), Repost("repost $i")))
        }

        findViewById<RecyclerView>(R.id.container).apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        Pair(post,repost)
        myAdapter.addElement(list)

        findViewById<Button>(R.id.button).setOnClickListener {
            myAdapter.removeElementPoPost(post)
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            myAdapter.add(Pair(post,repost))
        }

    }

}