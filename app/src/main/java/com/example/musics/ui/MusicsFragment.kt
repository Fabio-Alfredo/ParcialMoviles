package com.example.musics.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.music.data.Music
import com.example.musics.MusicApplication
import com.example.musics.R
import com.example.musics.adapter.MusicAdapter
import com.example.musics.databinding.FragmentMusicsBinding
import com.example.musics.viewModels.MusicsViewModels

class MusicsFragment : Fragment() {

    private lateinit var binding: FragmentMusicsBinding
    private lateinit var adapter:MusicAdapter
    private val viewModel:MusicsViewModels by activityViewModels {
        MusicsViewModels.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_musics, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listeners()
        setRecyclerView()
    }

    private fun listeners() {
        binding.newMusicButtom.setOnClickListener {
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_musicsFragment_to_newMusicFragment)
        }
    }

    fun selectItem(music: Music){
        viewModel.selectMusic(music)
        findNavController().navigate(R.id.action_musicsFragment_to_musicFragment)
    }

    fun displayItem(){
        adapter.setData(viewModel.getMusics())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(){
        //binding.recyclerviewMusic.layoutManager = LinearLayoutManager(view.context)

        adapter = MusicAdapter {selected->
            selectItem(selected)
        }

        binding.recyclerviewMusic.adapter = adapter
        displayItem()
    }

}