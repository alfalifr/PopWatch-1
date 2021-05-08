package com.mellagusty.movieapppopcorn.repository

import com.mellagusty.movieapppopcorn.data.remote.PopWatchDataSource
import com.mellagusty.movieapppopcorn.data.remote.RemoteDataSource

class FakeRepository (private val remoteDataSource: RemoteDataSource) :
    PopWatchDataSource {

    override fun getNowPlayingMovie() = remoteDataSource.getNowPlayingMovie()

    override fun getDetailMovie(movie_id: String) = remoteDataSource.getDetailMovie(movie_id)

    override fun getPopularTvShow() = remoteDataSource.getPopularTvShow()

    override fun getDetailTvShow(tv_id: String) = remoteDataSource.getDetailTvShow(tv_id)



}