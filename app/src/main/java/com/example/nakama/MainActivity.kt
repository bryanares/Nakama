package com.example.nakama

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.nakama.databinding.ActivityMainBinding
import com.example.nakama.ui.DetailsActivity
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val animeViewModel: AnimeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        //force light mode on physical testing device
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        animeViewModel.getAnime()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

//        var animeTitle = animeViewModel.anime.value?.data?.title
//        binding.animeTitleTv.text = animeTitle
        Picasso.get().load(animeViewModel.anime.value?.data?.images?.jpg?.image_url)
            .into(binding.animeImageView)
        binding.animeTitleTv.text = animeViewModel.anime.value?.data?.title
        binding.animeDescTv.text = animeViewModel.anime.value?.data?.synopsis
        binding.animeRatingTv.text = animeViewModel.anime.value?.data?.rating

        setContentView(view)

        //set onClickListener for button to navigate to DetailsActivity
        binding.animeCard.setOnClickListener {
            //set up intent
            val intent = Intent(this, DetailsActivity::class.java)

//            intent.putExtra("image", binding.animeImageView.id)
            intent.putExtra("image", binding.animeImageView.id.toString())
            intent.putExtra("title", binding.animeTitleTv.text)
            intent.putExtra("description", binding.animeDescTv.text)
            intent.putExtra("rating", binding.animeRatingTv.text)

            startActivity(intent)
        }

        binding.refreshBtn.setOnClickListener {
            animeViewModel.getAnime()
//            Glide.with(view.context)
//                .load(animeViewModel.anime.value?.data?.images?.jpg?.image_url)
//                .into(binding.animeImageView)

            Picasso.get().load(animeViewModel.anime.value?.data?.images?.webp?.image_url)
                .resize(378, 330)
                .into(binding.animeImageView)
            binding.animeTitleTv.text = animeViewModel.anime.value?.data?.title
            binding.animeDescTv.text = animeViewModel.anime.value?.data?.synopsis
            binding.animeRatingTv.text = animeViewModel.anime.value?.data?.rating

//            var animeTitle = animeViewModel.anime.value?.data?.title
//            binding.animeTitleTv.text = animeTitle
        }
    }

}