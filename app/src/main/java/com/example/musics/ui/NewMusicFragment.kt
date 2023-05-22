package com.example.musics.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.musics.R
import com.example.musics.databinding.FragmentNewMusicBinding
import com.example.musics.viewModels.MusicsViewModels

class NewMusicFragment : Fragment() {

    private lateinit var binding: FragmentNewMusicBinding

    private val viewModel:MusicsViewModels by viewModels{
        MusicsViewModels.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_music, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = viewModel
        observerStatus()
    }

    companion object{
        const val APP_TAG = "APP_TAG"
    }
    private fun observerStatus() {
        viewModel.status.observe(viewLifecycleOwner){
            when{
                it.equals(MusicsViewModels.WRONG_INFORMATION)->{
                    Log.d(APP_TAG, it)
                    viewModel.clearStatus()
                }
                it.equals(MusicsViewModels.MUSIC_CREATED)->{
                    Log.d(APP_TAG, it)
                    Log.d(APP_TAG, viewModel.getMusics().toString())

                    viewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }


}