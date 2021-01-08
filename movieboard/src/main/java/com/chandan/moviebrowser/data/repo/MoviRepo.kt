package com.chandan.moviebrowser.data.repo

import com.chandan.moviebrowser.data.remote.RemoteApiRequest
import com.chandan.moviebrowser.data.remote.RemoteMovieApi

class MoviRepo(
    private val api: RemoteMovieApi
) : RemoteApiRequest() {
    suspend fun getMovieList() = apiReq { api.getMovieList() }
}