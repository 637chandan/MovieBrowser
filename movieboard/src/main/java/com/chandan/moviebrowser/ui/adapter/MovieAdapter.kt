package com.chandan.moviebrowser.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chandan.moviebrowser.R
import com.chandan.moviebrowser.data.model.Movie
import com.chandan.moviebrowser.ui.adapter.utils.MovieViewHolder

class MovieAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var moviesList = ArrayList<Movie?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_movie, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MovieViewHolder -> {
                holder.bind(moviesList.get(position)!!)
            }
        }
    }

    fun setAdapter(newMovieList: List<Movie> ){
        moviesList.clear()
        moviesList.addAll(newMovieList)
        notifyDataSetChanged()
    }

}