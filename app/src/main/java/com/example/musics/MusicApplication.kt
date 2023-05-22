package com.example.musics

import android.app.Application
import com.example.music.data.musics
import com.example.musics.repositories.MusicRepository

class MusicApplication:Application() {

    val musicRepository:MusicRepository by lazy {
        MusicRepository(musics)
    }
}