package com.chandan.moviebrowser.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chandan.moviebrowser.data.model.Movie
import com.chandan.moviebrowser.data.repo.MovieRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomePageViewModel (
   private val movieRepo: MovieRepo
): ViewModel() {
    private var cacheMovieList = ArrayList<Movie?>()

    private var pageNo = 1
    private  var loadingMore =  true;


    private val movieData = MutableLiveData<List<Movie?>>()
    val movies: LiveData<List<Movie?>>
      get() = movieData


     fun getMovies() {
         viewModelScope.launch(Dispatchers.IO) {
             try {
                 cacheMovieList.addAll(movieRepo.getMovieList(pageNo).result)
                 movieData.postValue(cacheMovieList)
             } catch(e: Exception){
             }
         }
    }

    fun getMoreMovie() {
        if(loadingMore) return
        Log.i("Chandan","getting more movies "+ pageNo)
        loadingMore = true;
        pageNo++;
        getMovies()
    }

    fun setLoadingFalse() {
        loadingMore = false
    }
}