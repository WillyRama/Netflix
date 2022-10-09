package com.willyramad.netflix.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.willyramad.netflix.R
import com.willyramad.netflix.adapter.IMAGE_BASE
import com.willyramad.netflix.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    lateinit var binding : FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gambar = arguments?.getString("img")
        val rilis = arguments?.getString("rilis")
        val desc = arguments?.getString("detail")
        val jud = arguments?.getString("judul")
        val popular = arguments?.getString("reting")
        Glide.with(requireActivity()).load(IMAGE_BASE + gambar).into(binding.Img)

        binding.tvNama.text = "Title :"+ jud
        binding.tvRilis.text = "Release :"+ rilis
        binding.tvdesc.text = "Description :\n"+ desc
        binding.tvReting.text = "Rating :"+ popular
    }
}