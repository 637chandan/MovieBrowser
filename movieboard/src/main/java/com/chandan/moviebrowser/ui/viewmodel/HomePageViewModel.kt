package com.chandan.moviebrowser.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chandan.moviebrowser.data.model.Movie
import com.chandan.moviebrowser.data.repo.MovieRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomePageViewModel (
   private val movieRepo: MovieRepo
): ViewModel() {
    private val movieData = MutableLiveData<List<Movie?>>()
    private lateinit var job: Job
    val movies: LiveData<List<Movie?>>
      get() = movieData


     fun getMovies() {
         viewModelScope.launch(Dispatchers.IO) {
             try {
                 movieData.postValue(movieRepo.getMovieList())
             } catch(e: Exception){
             }
         }
    }
}