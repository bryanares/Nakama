package com.example.nakama.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nakama.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //declare screen properties
        val animeImage = binding.detailImageView
        val animeTitle = binding.detailTitleTv
        val animeDescription = binding.detailDescriptionTv
        val animeRating = binding.detailRatingTv

        //receive the intent
//        intent.getStringExtra("image")?.let { animeImage.setImageResource(it.toInt()) }
        animeTitle.text = intent.getStringExtra("title").toString()
        animeDescription.text = intent.getStringExtra("description").toString()
        animeRating.text = intent.getStringExtra("rating").toString()
    }
}