package com.mellagusty.movieapppopcorn.ui.tvshow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mellagusty.movieapppopcorn.data.remote.Poster
import com.mellagusty.movieapppopcorn.data.remote.Repository
import com.mellagusty.movieapppopcorn.data.remote.TvShowPosterDetail

class TvShowViewModel : ViewModel() {
    private lateinit var listTV: MutableLiveData<ArrayList<Poster>>
    private lateinit var detailTV: MutableLiveData<TvShowPosterDetail>

    //setforPopularTVShow
    fun setPopularTvShow() {
        listTV = Repository().setPopularTvShow()
    }

    fun getPopularTvShow() = listTV

    //setforDetailTVShow
    fun setDetailTvShow(tv_id: String) {
        detailTV = Repository().setDetailTvShow(tv_id)
    }

    fun getDetailTVShow() = detailTV

}