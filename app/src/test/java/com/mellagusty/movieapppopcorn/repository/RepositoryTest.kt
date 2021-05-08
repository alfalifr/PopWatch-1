package com.mellagusty.movieapppopcorn.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mellagusty.movieapppopcorn.data.DataDummyTest
import com.mellagusty.movieapppopcorn.data.remote.RemoteDataSource
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class RepositoryTest {
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val repository = FakeRepository(remote)

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun getListMovie() {
        Mockito.`when`(remote.getNowPlayingMovie()).thenReturn(DataDummyTest.generateDummyMovies())
        val movielist = repository.getNowPlayingMovie()
        Mockito.verify(remote).getNowPlayingMovie()
        Assert.assertNotNull(movielist)
        Assert.assertEquals(1, movielist.value?.size)

    }

    @Test
    fun getDetailMovie() {
        val detailMovie = DataDummyTest.generateDummyDetailMovie()
        val movie_id = detailMovie.value?.id
        Mockito.`when`(remote.getDetailMovie(movie_id.toString())).thenReturn(detailMovie)
        val movie = repository.getDetailMovie(movie_id.toString())
        Assert.assertNotNull(movie)
        Assert.assertEquals(detailMovie.value?.id, movie.value?.id)
        Assert.assertEquals(detailMovie.value?.original_title, movie.value?.original_title)
        Assert.assertEquals(detailMovie.value?.overview, movie.value?.overview)
        Assert.assertEquals(detailMovie.value?.genres, movie.value?.genres)
        Assert.assertEquals(detailMovie.value?.vote_average, movie.value?.vote_average)
        Assert.assertEquals(detailMovie.value?.tagline, movie.value?.tagline)
        Assert.assertEquals(detailMovie.value?.status, movie.value?.status)
    }

    @Test
    fun getListTvShow() {
        Mockito.`when`(remote.getPopularTvShow()).thenReturn(DataDummyTest.generateDummyTvShow())
        val show = repository.getPopularTvShow()
        Mockito.verify(remote).getPopularTvShow()
        Assert.assertNotNull(show)
        Assert.assertEquals(1, show.value?.size)
    }

    @Test
    fun getDetailTvShow() {
        val detailTvShow = DataDummyTest.generateDummyDetailTvShow()
        val tv_id = detailTvShow.value?.id
        Mockito.`when`(remote.getDetailTvShow(tv_id.toString())).thenReturn(detailTvShow)
        val television = repository.getDetailTvShow(tv_id.toString())
        Assert.assertNotNull(television)
        Assert.assertEquals(detailTvShow.value?.id, television.value?.id)
        Assert.assertEquals(detailTvShow.value?.original_name, television.value?.original_name)
        Assert.assertEquals(detailTvShow.value?.original_language, television.value?.original_language)
        Assert.assertEquals(detailTvShow.value?.genres, television.value?.genres)
        Assert.assertEquals(detailTvShow.value?.overview, television.value?.overview)
        Assert.assertEquals(detailTvShow.value?.status, television.value?.status)
        Assert.assertEquals(detailTvShow.value?.vote_average, television.value?.vote_average)
    }
}