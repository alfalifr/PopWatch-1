package com.mellagusty.movieapppopcorn.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mellagusty.movieapppopcorn.Test.getandwaitValue
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MovieViewModelTest {

    private lateinit var movieViewModel: MovieViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel()
    }

    //ViewModel ini sudah mengambil data dari API
    @Test
    fun getListMovie() {
        movieViewModel.setNowPlayingMovie()
        val movielist = movieViewModel.listMovie.getandwaitValue()
        assertNotNull(movielist)
        val movie1 = movielist.random()
        val movie2 = movielist.random()
        assert(movie1.original_title?.isNotBlank() == true)
        assert(movie2.release_date?.isNotBlank() == true)
        println("movie1 = $movie1")
        println("movie2 =  $movie2")

    }

    @Test
    fun getDetailMovie() {
        val detailId = "711017"
        val movieTitle = "Shorta"
        val movieOverview = "The exact details of what took place while Talib Ben Hassi"
        val movieLanguage = "da"
        val movieVoteAverage = 6.1
        val movieStatus = "Released"
        movieViewModel.setDetailMovie(detailId)
        val moviedetail = movieViewModel.detailMovie.getandwaitValue()
        assertNotNull(moviedetail)
        assertEquals(moviedetail.id.toString(), detailId)
        assertEquals(moviedetail.original_title, movieTitle)
        assert(moviedetail.overview?.contains(movieOverview) == true)
        assertEquals(moviedetail.original_language, movieLanguage)
        assertEquals(moviedetail.vote_average, movieVoteAverage)
        assertEquals(moviedetail.status, movieStatus)


    }
}