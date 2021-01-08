package com.chandan.moviebrowser.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chandan.moviebrowser.data.model.Movie

class HomePageViewModel : ViewModel() {
    private var mMovieList = ArrayList<Movie?>()
    private val mMovieLiveData = MutableLiveData<ArrayList<Movie?>>()
}