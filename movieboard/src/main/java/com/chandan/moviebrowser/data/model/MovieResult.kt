package com.chandan.moviebrowser.data.model

import com.google.gson.annotations.SerializedName

data class MovieResult (
    @SerializedName("page")
    var page: Int,
    @SerializedName("results")
    var result: ArrayList<Movie?>,
    @SerializedName("total_pages")
    var totalPages: Int,
    @SerializedName("total_results")
    var totalResult: Double
)