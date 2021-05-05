package com.mellagusty.movieapppopcorn.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mellagusty.movieapppopcorn.Test.getandwaitValue
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TvShowViewModelTest {

    private lateinit var tvShowViewModel: TvShowViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        tvShowViewModel = TvShowViewModel()
    }

    //ViewModel ini sudah mengambil data dari API
    @Test
    fun getListTV() {
        tvShowViewModel.setPopularTvShow()
        val tvshowList = tvShowViewModel.listTV.getandwaitValue()
        assertNotNull(tvshowList)
        val tvShowList1 = tvshowList.random()
        val tvShowList2 = tvshowList.random()
        assert(tvShowList1.original_name?.isNotBlank() == true)
        assert(tvShowList2.first_air_date?.isNotBlank() == true)
        println("TvShow1 = $tvShowList1")
        println("TvShow2 = $tvShowList2")
    }

    @Test
    fun getDetailTV() {
        val idTV = "71712"
        val tvName = "The Good Doctor"
        val tvOverview = "A young surgeon with Savant syndrome is recruited into the surgical"
        val tvStatus = "Returning Series"
        val tvVote = 8.6
        val tvTagLine = "His mind is a mystery, his methods are a miracle."
        val tvEpisode = 71
        val tvLanguage = "en"
        val tvType = "Scripted"

        tvShowViewModel.setDetailTvShow(idTV)
        val tvdetail = tvShowViewModel.detailTV.getandwaitValue()
        assertNotNull(tvdetail)
        assertEquals(tvdetail.id.toString(), idTV)
        assertEquals(tvdetail.original_name, tvName)
        assert(tvdetail.overview?.contains(tvOverview) == true)
        assertEquals(tvdetail.status, tvStatus)
        assertEquals(tvdetail.vote_average, tvVote)
        assertEquals(tvdetail.tagline, tvTagLine)
        assertEquals(tvdetail.number_of_episodes, tvEpisode)
        assertEquals(tvdetail.original_language, tvLanguage)
        assertEquals(tvdetail.type, tvType)
    }

}