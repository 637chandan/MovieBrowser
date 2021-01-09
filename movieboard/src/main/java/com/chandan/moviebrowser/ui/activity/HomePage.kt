package com.chandan.moviebrowser.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chandan.moviebrowser.R
import com.chandan.moviebrowser.data.model.Movie
import com.chandan.moviebrowser.data.remote.RemoteMovieApi
import com.chandan.moviebrowser.data.repo.MovieRepo
import com.chandan.moviebrowser.databinding.ActivityHomePageBinding
import com.chandan.moviebrowser.ui.adapter.MovieAdapter
import com.chandan.moviebrowser.ui.viewmodel.HomePageModelFactory
import com.chandan.moviebrowser.ui.viewmodel.HomePageViewModel

class HomePage : AppCompatActivity() {
    private lateinit var homeViewModelFactory: HomePageModelFactory
    private lateinit var viewModel: HomePageViewModel
    private  lateinit var movieAdapter: MovieAdapter
    private lateinit var dataBind: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUp()
        intiDataBind()
        addObserver()
        viewModel.getMovies()

    }

    private fun setUp(){
        val repo = MovieRepo(RemoteMovieApi())
        homeViewModelFactory = HomePageModelFactory(repo);
        viewModel = ViewModelProvider(this,homeViewModelFactory).get(HomePageViewModel::class.java)
        movieAdapter =  MovieAdapter()
    }
    private fun intiDataBind() {
        dataBind = DataBindingUtil.setContentView(this, R.layout.activity_home_page)
        dataBind.recyclerViewMovies.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }
    }

    private fun addObserver() {
        viewModel.movies.observe(this, Observer {
            Toast.makeText(this,( viewModel.movies.value as List<Movie>).toString(), Toast.LENGTH_LONG)
            dataBind.recyclerViewMovies.visibility = View.VISIBLE
            movieAdapter.setAdapter(viewModel.movies.value as List<Movie>)
        })
    }

}