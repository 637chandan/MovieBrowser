package com.chandan.moviebrowser.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.chandan.moviebrowser.R
import com.chandan.moviebrowser.data.remote.RemoteMovieApi
import com.chandan.moviebrowser.data.repo.MovieRepo
import com.chandan.moviebrowser.ui.viewmodel.HomePageModelFactory
import com.chandan.moviebrowser.ui.viewmodel.HomePageViewModel

class HomePage : AppCompatActivity() {
    private lateinit var homeViewModelFactory: HomePageModelFactory
    private lateinit var viewModel: HomePageViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        val repo = MovieRepo(RemoteMovieApi())
        homeViewModelFactory = HomePageModelFactory(repo);
        viewModel = ViewModelProvider(this,homeViewModelFactory).get(HomePageViewModel::class.java)

    }
}