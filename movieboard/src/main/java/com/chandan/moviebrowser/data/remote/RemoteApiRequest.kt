package com.chandan.moviebrowser.data.remote

import retrofit2.Response
import java.io.IOException

abstract class RemoteApiRequest {
    suspend fun <T : Any> apiReq(remoteCall: suspend () -> Response<T>): T {
       val response = remoteCall.invoke()
        if(response.isSuccessful){
            return response.body()!!
        } else {
            throw IOException(response.code().toString())
        }
    }
}