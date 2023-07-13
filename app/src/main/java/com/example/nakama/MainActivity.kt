package com.example.nakama

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.nakama.databinding.ActivityMainBinding
import com.example.nakama.ui.DetailsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        //force light mode on physical testing device
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //set onClickListener for button to navigate to DetailsActivity
        binding.animeCard.setOnClickListener {
            //set up intent
            val intent = Intent(this, DetailsActivity::class.java )
//            intent.putExtra("image", R.drawable.spiderman)
            intent.putExtra("title", binding.animeTitleTv.text)
            intent.putExtra("description", binding.animeDescTv.text)
            intent.putExtra("rating", binding.animeRatingTv.text)

            startActivity(intent)
        }
    }

}