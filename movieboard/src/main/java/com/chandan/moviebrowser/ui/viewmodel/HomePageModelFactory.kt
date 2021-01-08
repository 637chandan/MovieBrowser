package com.chandan.moviebrowser.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chandan.moviebrowser.data.repo.MovieRepo

@Suppress("UNCHECKED_CAST")
class HomePageModelFactory(
    private val repo: MovieRepo
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomePageViewModel(repo) as T
    }
}