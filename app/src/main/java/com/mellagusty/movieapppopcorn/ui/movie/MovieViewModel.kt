package com.mellagusty.movieapppopcorn.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mellagusty.movieapppopcorn.data.remote.MoviePosterDetail
import com.mellagusty.movieapppopcorn.data.remote.Poster
import com.mellagusty.movieapppopcorn.data.remote.Repository

class MovieViewModel : ViewModel() {
    private lateinit var listMovie: MutableLiveData<ArrayList<Poster>>
    private lateinit var detailMovie: MutableLiveData<MoviePosterDetail>

    //setforNowPlayingMovie
    fun setNowPlayingMovie() {
        listMovie = Repository().setNowPlayingMovie()
    }

    fun getNowPlayingMovie() = listMovie

    //SetGet Detail User
    fun setDetailMovie(movie_id: String) {
        detailMovie = Repository().setDetailMovie(movie_id)
    }

    fun gerDetailMovie() = detailMovie

}
