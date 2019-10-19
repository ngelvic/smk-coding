package com.bn.smkcoding51019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val movie = intent.getParcelableExtra<MovieModel>("movie")

        tv_title_movie.text = movie.title
        tv_rating_movie.text = "rating : ${movie.rating}"
        tv_description_movie.text = movie.description
        Glide.with( this).load(movie.image).into(iv_poster_movie)
    }
}
