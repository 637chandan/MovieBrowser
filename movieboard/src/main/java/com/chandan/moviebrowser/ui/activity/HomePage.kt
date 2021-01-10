package com.chandan.moviebrowser.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chandan.moviebrowser.R
import com.chandan.moviebrowser.data.model.Movie
import com.chandan.moviebrowser.databinding.ActivityHomePageBinding
import com.chandan.moviebrowser.ui.adapter.MovieAdapter
import com.chandan.moviebrowser.ui.viewmodel.HomePageViewModel
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class HomePage : AppCompatActivity() {
    private val viewModel: HomePageViewModel by inject()
    private val movieAdapter: MovieAdapter by inject()
    private lateinit var dataBind: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUp()
        intiDataBind()
        addObserver()
        viewModel.getMovies()

    }

    private fun setUp(){
      //   movieAdapter = get<MovieAdapter>()
    }
    private fun intiDataBind() {
        dataBind = DataBindingUtil.setContentView(this, R.layout.activity_home_page)
        dataBind.recyclerViewMovies.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
            addOnScrollListener(object: RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager?
                    val visibleItemCount = layoutManager!!.childCount
                    val totalItemCount = layoutManager.itemCount
                    val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                    if(firstVisibleItemPosition + visibleItemCount >= totalItemCount && firstVisibleItemPosition >=0){
                        dataBind.progressBar.visibility = View.VISIBLE
                        Handler().postDelayed({
                            viewModel.getMoreMovie()
                        }, 1000)
                    }

                }


            })
        }
    }

    private fun addObserver() {
        viewModel.movies.observe(this, Observer {
            dataBind.recyclerViewMovies.visibility = View.VISIBLE
            movieAdapter.setAdapter(viewModel.movies.value as List<Movie>)
            dataBind.progressBar.visibility = View.GONE
            Handler().postDelayed({
                viewModel.setLoadingFalse()
            }, 2000)
        })
    }
}

