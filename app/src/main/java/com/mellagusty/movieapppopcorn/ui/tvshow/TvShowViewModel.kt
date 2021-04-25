package com.mellagusty.movieapppopcorn.ui.tvshow

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mellagusty.movieapppopcorn.EspressoIdlingResource
import com.mellagusty.movieapppopcorn.api.DataResponse
import com.mellagusty.movieapppopcorn.api.RetrofitClient
import com.mellagusty.movieapppopcorn.data.Poster
import com.mellagusty.movieapppopcorn.data.TvShowPosterDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowViewModel : ViewModel() {

    val listTV = MutableLiveData<ArrayList<Poster>>()
    val detailTV = MutableLiveData<TvShowPosterDetail>()


    fun setPopularTvShow() {
        //Do increment Idling(testing)
        EspressoIdlingResource.increment()

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
                    EspressoIdlingResource.decrement()

                    if (response.isSuccessful) {
                        listTV.postValue(response.body()?.results as ArrayList<Poster>?)
                    }
                }

            })
    }

    fun getPopularTvShow() = listTV

    //setget Detail

    fun setDetailTvShow(tv_id: String) {
        //Do increment Idling(testing)
        EspressoIdlingResource.increment()

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
                    EspressoIdlingResource.decrement()

                    if (response.isSuccessful) {
                        detailTV.postValue(response.body())
                    }
                }

            })
    }

    fun getDetailTVShow() = detailTV

}