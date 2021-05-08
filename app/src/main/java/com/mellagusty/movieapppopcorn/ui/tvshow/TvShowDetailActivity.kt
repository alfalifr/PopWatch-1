package com.mellagusty.movieapppopcorn.ui.tvshow

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.mellagusty.movieapppopcorn.data.remote.Poster
import com.mellagusty.movieapppopcorn.databinding.ActivityTvShowDetailBinding
import com.mellagusty.movieapppopcorn.ui.movie.MovieViewModel
import com.mellagusty.movieapppopcorn.viewmodel.PopViewModelRequest

class TvShowDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTvShowDetailBinding
    private lateinit var tvShowModel: TvShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvShowDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvshow = intent.getParcelableExtra<Poster>(EXTRA_TV) as Poster

        val factory = PopViewModelRequest.getInstance(this)
        tvShowModel =  ViewModelProvider(this, factory)[TvShowViewModel::class.java]

        //Set For Back Arrow
        binding.back.setOnClickListener {
            onBackPressed()
        }
        //call the function
        tvShowModel.setDetailTvShow(tvshow.id)
        observeViewModel()

    }

    private fun observeViewModel() {
        tvShowModel.getDetailTVShow().observe(this, { tvdetail ->
            binding.tvLanguage.text = tvdetail.original_language
            binding.tvType.text = tvdetail.type
            binding.tvStatus.text = tvdetail.status
            binding.tvStar.text = tvdetail.vote_average.toString()
            binding.tvGenres.text = tvdetail.genres.joinToString { it.name }
            binding.tvEpisodeTotal.text = tvdetail.number_of_episodes.toString()
            binding.tvOriginalName.text = tvdetail.original_name
            binding.tvTagline.text = tvdetail.tagline
            binding.tvOverview.text = tvdetail.overview
            Glide.with(this)
                .load(tvdetail.baseUrl + tvdetail.poster_path)
                .into(binding.ivTvDetail)

            showLoading(false)
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    companion object {
        const val EXTRA_TV = "extra_tv"
    }
}