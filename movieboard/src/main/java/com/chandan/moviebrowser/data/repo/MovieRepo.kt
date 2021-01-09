package com.chandan.moviebrowser.data.repo

import com.chandan.moviebrowser.data.remote.RemoteApiRequest
import com.chandan.moviebrowser.data.remote.RemoteMovieApi
import com.chandan.moviebrowser.util.Constants.API_KEY
import com.chandan.moviebrowser.util.Constants.CATEGORY
import com.chandan.moviebrowser.util.Constants.LANGUAGE

class MovieRepo(
    private val apiRemote: RemoteMovieApi
) : RemoteApiRequest() {
    suspend fun getMovieList() = apiReq { apiRemote.getMovieList(CATEGORY,API_KEY,LANGUAGE,1) }
}