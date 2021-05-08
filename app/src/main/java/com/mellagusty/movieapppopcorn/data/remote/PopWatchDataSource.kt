package com.mellagusty.movieapppopcorn.data.remote

import androidx.lifecycle.MutableLiveData

interface PopWatchDataSource {

    fun getNowPlayingMovie() : MutableLiveData<ArrayList<Poster>>

    fun getDetailMovie(movie_id: String) : MutableLiveData<MoviePosterDetail>

    fun getPopularTvShow(): MutableLiveData<ArrayList<Poster>>

    fun getDetailTvShow(tv_id: String): MutableLiveData<TvShowPosterDetail>
}