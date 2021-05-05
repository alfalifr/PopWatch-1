package com.mellagusty.movieapppopcorn.data.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mellagusty.movieapppopcorn.EspressoIdlingResource
import com.mellagusty.movieapppopcorn.data.remote.api.DataResponse
import com.mellagusty.movieapppopcorn.data.remote.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    //setforNowPlayingMovie
    fun setNowPlayingMovie(): MutableLiveData<ArrayList<Poster>> {
        val movies = MutableLiveData<ArrayList<Poster>>()
        //Do increment Idling(testing)
        try {
            EspressoIdlingResource.increment()
        } catch (e: Throwable) {
        }

        RetrofitClient.API_INSTANCE
            .getNowPlayingMovie()
            .enqueue(object : Callback<DataResponse> {
                override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                    t.message?.let { Log.d("failure", it) }
                    EspressoIdlingResource.decrement()
                }

                override fun onResponse(
                    call: Call<DataResponse>,
                    response: Response<DataResponse>
                ) {
                    //Do decrement Idling(testing)
                    try {
                        EspressoIdlingResource.decrement()
                    } catch (e: Throwable) {
                    }

                    if (response.isSuccessful) {
                        movies.postValue(response.body()?.results as ArrayList<Poster>?)
                    }
                }

            })
        return movies
    }

    fun setDetailMovie(movie_id: String): MutableLiveData<MoviePosterDetail> {
        val detailMovie = MutableLiveData<MoviePosterDetail>()
        //Do increment Idling(testing)
        try {
            EspressoIdlingResource.increment()
        } catch (e: Throwable) {
        }

        RetrofitClient.API_INSTANCE
            .getDetailMovie(movie_id)
            .enqueue(object : Callback<MoviePosterDetail> {
                override fun onFailure(call: Call<MoviePosterDetail>, t: Throwable) {
                    t.message?.let { Log.d("failure", it) }
                    //Do decrement Idling(testing)
                    EspressoIdlingResource.decrement()
                }

                override fun onResponse(
                    call: Call<MoviePosterDetail>,
                    response: Response<MoviePosterDetail>
                ) {

                    //Do decrement Idling(testing)
                    try {
                        EspressoIdlingResource.decrement()
                    } catch (e: Throwable) {
                    }

                    if (response.isSuccessful) {
                        detailMovie.postValue(response.body())
                    }
                }

            })
        return detailMovie
    }

    //setforPopularTVShow
    fun setPopularTvShow(): MutableLiveData<ArrayList<Poster>> {
        val tvseries = MutableLiveData<ArrayList<Poster>>()
        //Do increment Idling(testing)
        try {
            EspressoIdlingResource.increment()
        } catch (e: Throwable) {
        }

        RetrofitClient.API_INSTANCE
            .getPopularTvShow()
            .enqueue(object : Callback<DataResponse> {
                override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                    t.message?.let { Log.d("failure", it) }
                    //Do decrement Idling(testing)
                    EspressoIdlingResource.decrement()
                }

                override fun onResponse(
                    call: Call<DataResponse>,
                    response: Response<DataResponse>
                ) {
                    //Do decrement Idling(testing)
                    try {
                        EspressoIdlingResource.decrement()
                    } catch (e: Throwable) {
                    }

                    if (response.isSuccessful) {
                        tvseries.postValue(response.body()?.results as ArrayList<Poster>?)
                    }
                }

            })
        return tvseries

    }

    //setDetailForPopularTVShow
    fun setDetailTvShow(tv_id: String) : MutableLiveData<TvShowPosterDetail> {
        val tvdetail = MutableLiveData<TvShowPosterDetail>()
        //Do increment Idling(testing)
        try {
            EspressoIdlingResource.increment()
        } catch (e: Throwable) {
        }

        RetrofitClient.API_INSTANCE
            .getDetailTvShow(tv_id)
            .enqueue(object : Callback<TvShowPosterDetail> {
                override fun onFailure(call: Call<TvShowPosterDetail>, t: Throwable) {
                    t.message?.let { Log.d("failure", it) }
                    //Do decrement Idling(testing)
                    EspressoIdlingResource.decrement()
                }

                override fun onResponse(
                    call: Call<TvShowPosterDetail>,
                    response: Response<TvShowPosterDetail>
                ) {
                    //Do decrement Idling(testing)
                    try {
                        EspressoIdlingResource.decrement()
                    } catch (e: Throwable) {
                    }

                    if (response.isSuccessful) {
                        tvdetail.postValue(response.body())
                    }
                }

            })
        return tvdetail
    }

}