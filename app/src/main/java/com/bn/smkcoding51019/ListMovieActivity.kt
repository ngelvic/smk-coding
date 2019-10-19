package com.bn.smkcoding51019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list_movie.*
import org.jetbrains.anko.support.v4.viewPager

class ListMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movie)

        viewPager.adapter = TabLayoutAdapter(supportFragmentManager, this)

        tabLayout.setupWithViewPager(viewPager)
    }
}
