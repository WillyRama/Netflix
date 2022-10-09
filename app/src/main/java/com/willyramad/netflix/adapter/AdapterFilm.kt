package com.willyramad.netflix.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.willyramad.netflix.R
import com.willyramad.netflix.databinding.ItemFilmBinding
import com.willyramad.netflix.model.Result

class AdapterFilm(var listFilm : List<Result>): RecyclerView.Adapter<AdapterFilm.ViewHolder>() {
    class ViewHolder(var binding : ItemFilmBinding ) : RecyclerView.ViewHolder(binding.root) {
        fun bindFilm(result: Result){
            binding.tvNama.text = result.title
            binding.tvRilis.text = result.releaseDate
            binding.tvReting.text = result.voteAverage.toString()
            binding.tvdesc.text = result.overview
            Glide.with(itemView).load(IMAGE_BASE + result.posterPath).into(binding.Img)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemFilmBinding.inflate(LayoutInflater.from(parent.context),parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindFilm(listFilm[position])
        holder.binding.crFilm.setOnClickListener {
            val bundle = Bundle()
            val pos = listFilm[position]
            bundle.putString("judul", pos.title)
            bundle.putString("rilis", pos.releaseDate)
            bundle.putString("detail", pos.overview)
            bundle.putString("reting", pos.voteAverage.toString())
            bundle.putString("img", pos.posterPath)
            Navigation.findNavController(holder.itemView).navigate(R.id.action_homeFragment_to_detailFragment,bundle)
        }
    }

    override fun getItemCount(): Int {
        return listFilm.size
    }
}