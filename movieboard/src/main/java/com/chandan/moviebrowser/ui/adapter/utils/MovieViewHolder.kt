package com.chandan.moviebrowser.ui.adapter.utils

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chandan.moviebrowser.R
import com.chandan.moviebrowser.data.model.Movie


/*TO DO Need to move View Holder to Adapter class*/
class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private val title: TextView = itemView.findViewById(R.id.text_title)
    private val desc: TextView = itemView.findViewById(R.id.text_desc)
    private val year: TextView = itemView.findViewById(R.id.text_year)
    private val image: TextView = itemView.findViewById(R.id.text_image)

    fun bind(movie: Movie) {
        title.text = movie.title
        desc.text = movie.desc
        year.text = movie.year
        image.text = movie.image
        // add default for image error
        /*Glide.with(imagePoster.context).load(movie.poster)
            .centerCrop()
            .thumbnail(0.5f)
            .placeholder(R.drawable.ic_launcher_background)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imagePoster)*/
    }

}