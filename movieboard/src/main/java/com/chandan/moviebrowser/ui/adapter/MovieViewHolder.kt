package com.chandan.moviebrowser.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.chandan.moviebrowser.R
import com.chandan.moviebrowser.data.model.Movie
import com.chandan.moviebrowser.util.Constants.IMAGE_BASE_URL


/*TO DO Need to move View Holder to Adapter class*/
class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private val title: TextView = itemView.findViewById(R.id.text_title)
    private val rating : TextView = itemView.findViewById(R.id.text_rating)
    private val desc: TextView = itemView.findViewById(R.id.text_desc)
    private val image: ImageView = itemView.findViewById(R.id.image_poster)

    fun bind(movie: Movie) {
        title.text = movie.title
        desc.text = movie.overview
        rating.text = movie.voteAverage.toString()
        Glide.with(image.context).load(IMAGE_BASE_URL + movie.posterPath)
            .thumbnail(0.5f)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(image)
    }

}