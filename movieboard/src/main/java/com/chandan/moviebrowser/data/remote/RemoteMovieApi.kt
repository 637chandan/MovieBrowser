package com.chandan.moviebrowser.data.remote

import com.chandan.moviebrowser.data.model.Movie
import com.chandan.moviebrowser.data.model.MovieResult
import com.chandan.moviebrowser.util.Constants
import com.chandan.moviebrowser.util.Constants.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteMovieApi {

    @GET("/3/movie/{category}")
    suspend fun getMovieList(
            @Path(value = "category") searchCategory: String,
            @Query(value = "api_key") apiKey: String,
            @Query(value =  "language") lang: String,
            @Query(value = "page") page:Int
    ): Response<MovieResult>

    companion object {
        operator fun invoke(): RemoteMovieApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(RemoteMovieApi::class.java)
        }
    }
}