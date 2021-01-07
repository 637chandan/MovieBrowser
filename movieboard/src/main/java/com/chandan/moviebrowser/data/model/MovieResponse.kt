package com.chandan.moviebrowser.data.model

import com.chandan.moviebrowser.data.model.Movie

data class MovieResponse(

    var response: String,

    var error: String,

    var totalResults: String,

    var search: ArrayList<Movie?>

)