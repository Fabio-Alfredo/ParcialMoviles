package com.example.musics.repositories

import com.example.music.data.Music

class MusicRepository(private val musics:MutableList<Music>) {

    fun getMusics()=musics

    fun addMusic(music: Music) = musics.add(music)
}