package com.mellagusty.movieapppopcorn.ui.tvshow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mellagusty.movieapppopcorn.data.remote.MoviePosterDetail
import com.mellagusty.movieapppopcorn.data.remote.Poster
import com.mellagusty.movieapppopcorn.data.remote.Repository
import com.mellagusty.movieapppopcorn.data.remote.TvShowPosterDetail

class TvShowViewModel(private val repository: Repository) : ViewModel() {
    lateinit var listTV: MutableLiveData<ArrayList<Poster>>
    lateinit var detailTV: MutableLiveData<TvShowPosterDetail>

    //setforPopularTVShow
    fun setPopularTvShow() {
        listTV = repository.getPopularTvShow()

    }
    fun getPopularTvShow() = listTV

    //setforDetailTVShow
    fun setDetailTvShow(tv_id: String) {
        detailTV = repository.getDetailTvShow(tv_id)
    }
    fun getDetailTVShow() = detailTV

}