package com.mellagusty.movieapppopcorn.ui.movie

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mellagusty.movieapppopcorn.EspressoIdlingResource
import com.mellagusty.movieapppopcorn.api.DataResponse
import com.mellagusty.movieapppopcorn.api.RetrofitClient
import com.mellagusty.movieapppopcorn.data.MoviePosterDetail
import com.mellagusty.movieapppopcorn.data.Poster
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    val listMovie = MutableLiveData<ArrayList<Poster>>()
    val detailMovie = MutableLiveData<MoviePosterDetail>()


    //setforNowPlayingMovie
    fun setNowPlayingMovie() {
        //Do increment Idling(testing)
        EspressoIdlingResource.increment()

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
                    EspressoIdlingResource.decrement()

                    if (response.isSuccessful) {
                        listMovie.postValue(response.body()?.results as ArrayList<Poster>?)
                    }
                }

            })
    }

    fun getNowPlayingMovie() = listMovie

    //SetGet Detail User
    fun setDetailMovie(movie_id: String) {
        //Do increment Idling(testing)
        EspressoIdlingResource.increment()

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
                    EspressoIdlingResource.decrement()

                    if (response.isSuccessful) {
                        detailMovie.postValue(response.body())
                    }
                }

            })
    }

    fun gerDetailMovie() = detailMovie

}
