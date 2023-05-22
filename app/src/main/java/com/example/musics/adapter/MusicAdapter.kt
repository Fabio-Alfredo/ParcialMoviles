package com.example.musics.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.music.data.Music
import com.example.musics.databinding.ItemMusicBinding

class MusicAdapter(private val Click: (Music) -> Unit):RecyclerView.Adapter<MusicAdapter.ViewHolderMusic>() {

    private var musics:List<Music>?=null

    class ViewHolderMusic(private val binding: ItemMusicBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(music: Music, Click:(Music)->Unit){
            binding.nameMusic.text = music.name

            binding.cardviewNameMusic.setOnClickListener{
                Click(music)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMusic {
        val binding = ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderMusic(binding)
    }

    override fun getItemCount(): Int = musics?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolderMusic, position: Int) {
        musics?.let {
            holder.bind(it[position], Click)
        }
    }

    fun setData(musics:List<Music>){
        this.musics = musics
        notifyDataSetChanged()
    }
}