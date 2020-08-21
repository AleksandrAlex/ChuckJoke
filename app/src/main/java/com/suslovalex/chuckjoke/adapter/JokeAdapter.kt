package com.suslovalex.chuckjoke.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suslovalex.chuckjoke.R
import com.suslovalex.chuckjoke.databinding.ItemJokeBinding
import com.suslovalex.chuckjoke.model.Post
import com.suslovalex.chuckjoke.model.Value
import kotlinx.android.synthetic.main.item_joke.view.*
import java.util.zip.Inflater

class JokeAdapter() : RecyclerView.Adapter<JokeAdapter.ViewHolder>() {
    var data = listOf<Value>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_joke, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.textJoke.text = item.joke
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textJoke: TextView = view.textItemJoke
    }


}