package com.example.musics.viewModels

import android.text.Spannable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.music.data.Music
import com.example.music.data.instruments
import com.example.musics.MusicApplication
import com.example.musics.repositories.MusicRepository

class MusicsViewModels(private val musicRepository: MusicRepository):ViewModel() {

    val genero = MutableLiveData("")
    val instrumentos = MutableLiveData("")
    val name = MutableLiveData("")
    val status = MutableLiveData("")

    fun getMusics()=musicRepository.getMusics()
    fun addMusic(music: Music)= musicRepository.addMusic(music)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val viewMusic = (this[APPLICATION_KEY] as MusicApplication).musicRepository
                MusicsViewModels(viewMusic)
            }
        }

        const val  MUSIC_CREATED = "Music created"
        const val  WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }

    fun validateData():Boolean{
        when{
            name.value.isNullOrEmpty()->return false
            genero.value.isNullOrEmpty()->return false
            instrumentos.value.isNullOrEmpty()->return false
        }

        return true
    }

    fun createMusic(){
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val music = Music(
            name.value!!,
            genero.value!!,
            instrumentos.value!!
        )

        addMusic(music)
        clearData()
        status.value = MUSIC_CREATED
    }

     fun clearData() {
        name.value = ""
        genero.value =""
        instrumentos.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun selectMusic(music: Music){
        name.value = music.name
        genero.value = music.genero
        instrumentos.value = music.instrumentos
    }
}