package com.chandan.moviebrowser.data.remote

import com.chandan.moviebrowser.data.model.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RemoteMovieApi {

    @GET("movies")
    suspend fun getMovieList(): Response<List<Movie>>

    companion object {
        operator fun invoke(): RemoteMovieApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.simplifiedcoding.in/course-apis/recyclerview/")
                .build()
                .create(RemoteMovieApi::class.java)
        }
    }
}