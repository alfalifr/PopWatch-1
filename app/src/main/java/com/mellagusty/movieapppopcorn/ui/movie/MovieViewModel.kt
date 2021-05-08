package com.mellagusty.movieapppopcorn.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mellagusty.movieapppopcorn.data.remote.MoviePosterDetail
import com.mellagusty.movieapppopcorn.data.remote.Poster
import com.mellagusty.movieapppopcorn.data.remote.Repository

class MovieViewModel(private val repository: Repository) : ViewModel() {
    lateinit var listMovie: MutableLiveData<ArrayList<Poster>>
    lateinit var detailMovie: MutableLiveData<MoviePosterDetail>

    //setforNowPlayingMovie
    fun setNowPlayingMovie(){
        listMovie = repository.getNowPlayingMovie()
    }

    fun getNowPlayingMovie() = listMovie

    //SetGet Detail Movie
    fun setDetailMovie(movie_id: String){
       detailMovie = repository.getDetailMovie(movie_id)
    }
    fun gerDetailMovie() = detailMovie

}
