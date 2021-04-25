package com.mellagusty.movieapppopcorn.ui.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.mellagusty.movieapppopcorn.data.Poster
import com.mellagusty.movieapppopcorn.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var movieDetailViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra<Poster>(EXTRA_MOVIE) as Poster

        movieDetailViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MovieViewModel::class.java)

        //Set For Back Arrow
        binding.back.setOnClickListener {
            onBackPressed()
        }
        //call the function
        movieDetailViewModel.setDetailMovie(movie.id)
        observeViewModel()
    }

    private fun observeViewModel() {
        movieDetailViewModel.gerDetailMovie().observe(this, Observer { moviedetail ->
            binding.tvLanguage.text = moviedetail.original_language
            binding.tvGenres.text = moviedetail.genres.joinToString { it.name }
            binding.tvOriginalName.text = moviedetail.original_title
            binding.tvOverview.text = moviedetail.overview
            binding.tvTagline.text = moviedetail.tagline
            binding.tvStatus.text = moviedetail.status
            binding.tvStar.text = moviedetail.vote_average.toString()
            Glide.with(this)
                .load(moviedetail.baseUrl+moviedetail.poster_path )
                .into(binding.ivMovieDetail)


        })
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }
}
