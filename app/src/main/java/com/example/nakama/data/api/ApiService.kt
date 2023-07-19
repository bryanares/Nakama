package com.example.nakama.data.api

import com.example.nakama.data.models.anime
import retrofit2.http.GET

interface AnimeApi {

    @GET("random/anime")
    suspend fun getAnime(): anime
}