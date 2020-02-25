package com.examples.coding.rxjavademo.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.examples.coding.networkingdemoone.model.ChuckNorrisResponse.JokeResponse
import com.examples.coding.rxjavademo.R
import kotlinx.android.synthetic.main.joke_item.view.*

class JokesAdapter() : RecyclerView.Adapter<JokesAdapter.ViewHolder>() {
   val jokeList = ArrayList<JokeResponse>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.joke_item, parent, false))


    override fun getItemCount() = jokeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)  =
        holder.populateJoke(jokeList[position])

    fun addJoke(jokeToAdd : JokeResponse) {
        jokeList.add(jokeToAdd)
        notifyDataSetChanged()
    }
    inner class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
         fun populateJoke(jokeResponse: JokeResponse) {
            itemView.tvJoke.text = jokeResponse.value.joke
            itemView.tvType.text = jokeResponse.type
            itemView.tvId.text = jokeResponse.value.id.toString()
        }
    }


}