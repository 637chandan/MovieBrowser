package com.chandan.moviebrowser.data.repo

import com.chandan.moviebrowser.data.remote.RemoteApiRequest
import com.chandan.moviebrowser.data.remote.RemoteMovieApi

class MovieRepo(
    private val apiRemote: RemoteMovieApi
) : RemoteApiRequest() {
    suspend fun getMovieList() = apiReq { apiRemote.getMovieList() }
}