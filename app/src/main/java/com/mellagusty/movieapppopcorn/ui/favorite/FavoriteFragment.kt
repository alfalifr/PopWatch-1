package com.mellagusty.movieapppopcorn.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mellagusty.movieapppopcorn.R

class FavoriteFragment : Fragment() {

    private lateinit var favoriteViewModel: FavoriteViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        favoriteViewModel =
                ViewModelProvider(this).get(FavoriteViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_favorite, container, false)
        return root
    }
}