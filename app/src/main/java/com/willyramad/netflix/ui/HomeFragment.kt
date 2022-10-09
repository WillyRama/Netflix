package com.willyramad.netflix.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.willyramad.netflix.R
import com.willyramad.netflix.adapter.AdapterFilm
import com.willyramad.netflix.databinding.FragmentHomeBinding
import com.willyramad.netflix.vm.ViewModelFilm

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var adapterFilm: AdapterFilm
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireContext().getSharedPreferences("user", Context.MODE_PRIVATE)
        setDataFilm()
        sharedPreferences.getString("Email","")
        sharedPreferences.getString("Nama", "")

        val wel = sharedPreferences.getString("User","")
        binding.tvHeaderUser.text ="Selamat datang "+ wel

        binding.profil.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_profilFragment2)
        }
    }
    fun setDataFilm(){
        val viewmodel =ViewModelProvider(requireActivity()).get(ViewModelFilm::class.java)
        viewmodel.getAllFilm().observe(viewLifecycleOwner, Observer {
            if (it !=null){
                binding.rvFilm.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                adapterFilm = AdapterFilm(it.results)
                binding.rvFilm.adapter = adapterFilm
            }else{
                Toast.makeText(context, "Data kosong", Toast.LENGTH_SHORT).show()
            }
        })
        viewmodel.callAllFilm()

    }
}