package com.mellagusty.movieapppopcorn.data.remote

class Repository private constructor(private val remoteDataSource: RemoteDataSource) : PopWatchDataSource {

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(remoteData: RemoteDataSource): Repository =
            instance ?: synchronized(this) {
                Repository(remoteData).apply { instance = this }
            }
    }

    override fun getNowPlayingMovie() = remoteDataSource.getNowPlayingMovie()

    override fun getDetailMovie(movie_id: String) = remoteDataSource.getDetailMovie(movie_id)

    override fun getPopularTvShow() = remoteDataSource.getPopularTvShow()

    override fun getDetailTvShow(tv_id: String) = remoteDataSource.getDetailTvShow(tv_id)



}