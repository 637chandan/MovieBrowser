package com.chandan.moviebrowser.di

import com.chandan.moviebrowser.data.remote.RemoteMovieApi
import com.chandan.moviebrowser.data.repo.MovieRepo
import com.chandan.moviebrowser.ui.adapter.MovieAdapter
import com.chandan.moviebrowser.ui.viewmodel.HomePageModelFactory
import com.chandan.moviebrowser.ui.viewmodel.HomePageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule = module {
    single { RemoteMovieApi() }
    single { MovieRepo(get()) }
    single { HomePageModelFactory(get()) }
    single { MovieAdapter() }
}

val viewModule = module {
    viewModel { HomePageViewModel(get()) }
}