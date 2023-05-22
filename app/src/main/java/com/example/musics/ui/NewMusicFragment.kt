package com.example.musics.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.musics.R
import com.example.musics.databinding.FragmentNewMusicBinding

class NewMusicFragment : Fragment() {

    private lateinit var binding: FragmentNewMusicBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_music, container, false)
        return binding.root
    }


}