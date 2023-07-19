package com.example.nakama

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nakama.data.api.RetrofitInstance
import com.example.nakama.data.models.anime
import kotlinx.coroutines.launch
import java.lang.Exception

class AnimeViewModel : ViewModel() {

    private var _anime = MutableLiveData<anime>()
    val anime: LiveData<anime> get() = _anime

    //    val animeItem = anime.value?.data
    init {
        getAnime()
    }

    fun getAnime(): MutableLiveData<anime> {
        viewModelScope.launch {
            try {
                _anime.value = RetrofitInstance.api.getAnime()
                Log.d("viewModel", anime.value?.data.toString())
            } catch (e: Exception) {
                Log.e("ViewModel", e.toString())

            }
        }
        return _anime
    }
}