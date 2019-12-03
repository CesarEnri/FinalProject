package com.test.appthemoviedb.UI.detalle_de_peliculas

import androidx.lifecycle.LiveData
import com.test.appthemoviedb.data.api.TheMovieDBInterface
import com.test.appthemoviedb.data.repository.MovieDetailsNetworkDataSource
import com.test.appthemoviedb.data.repository.NetworkState
import com.test.appthemoviedb.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }



}