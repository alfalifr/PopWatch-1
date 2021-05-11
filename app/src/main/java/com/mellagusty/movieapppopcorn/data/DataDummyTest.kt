package com.mellagusty.movieapppopcorn.data

import androidx.lifecycle.MutableLiveData
import com.mellagusty.movieapppopcorn.data.remote.*

object DataDummyTest {

    fun generateDummyMovies(): MutableLiveData<ArrayList<Poster>> {

        val listMovies = MutableLiveData<ArrayList<Poster>>()

        listMovies.value = arrayListOf(
            Poster(
                "8932874",
                "2021-02-24",
                "2020-10-16",
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "Chaos Walking",
                "The Marksman"

            )
        )

        return listMovies
    }

    fun generateDummyDetailMovie(): MutableLiveData<MoviePosterDetail> {

        val detailMovie = MutableLiveData<MoviePosterDetail>()

        detailMovie.value = (
                MoviePosterDetail(
                    873974,
                    "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                    "Chaos Walking",
                    "In Prentisstown, Todd has been brought up to believe that the Spackle released a germ that killed all the women ",
                    "en",
                    listOf(GenreModel("drama", 32)),
                    8.3,
                    null,
                    "released"
                )
                )
        return detailMovie
    }

    fun generateDummyTvShow(): MutableLiveData<ArrayList<Poster>> {

        val listTvShow = MutableLiveData<ArrayList<Poster>>()

        listTvShow.value = arrayListOf(
            Poster(
                "8932874",
                "2021-02-24",
                "2020-10-16",
                "jfdhfjd.jpg",
                "Chaos Walking",
                "The Marksman"
            )

        )
        return listTvShow
    }

    fun generateDummyDetailTvShow(): MutableLiveData<TvShowPosterDetail> {

        val detailTvShow = MutableLiveData<TvShowPosterDetail>()

        detailTvShow.value = (
                TvShowPosterDetail(
                    894593,
                    "Wandavision",
                    "en",
                    "Several hundred years ago, humans were nearly exterminated by Titans. Titans are typically several stories tall.",
                    "Released",
                    9,
                    9.3,
                    "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                    listOf(GenreModels("thriller", 36)),
                    "Scripted",
                    null
                )
                )
        return detailTvShow
    }

}