package com.mellagusty.movieapppopcorn.di

import android.content.Context
import com.mellagusty.movieapppopcorn.data.remote.Repository
import com.mellagusty.movieapppopcorn.data.remote.RemoteDataSource
import com.mellagusty.movieapppopcorn.data.remote.api.RetrofitClient

object PopWatchInjection {
    fun provideRepository(context: Context): Repository {
        val api = RetrofitClient.API_INSTANCE

        val remoteDataSource = RemoteDataSource.getInstances(api)

        return Repository.getInstance(remoteDataSource)
    }
}