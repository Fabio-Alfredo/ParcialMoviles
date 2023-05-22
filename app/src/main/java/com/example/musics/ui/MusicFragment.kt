package com.example.musics.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.musics.R
import com.example.musics.databinding.FragmentMusicBinding
import com.example.musics.viewModels.MusicsViewModels

class MusicFragment : Fragment() {

    private lateinit var binding: FragmentMusicBinding

    private val viewModel: MusicsViewModels by activityViewModels {
        MusicsViewModels.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_music, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = viewModel
    }

}