package com.willyramad.netflix.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.willyramad.netflix.R
import com.willyramad.netflix.databinding.FragmentProfilBinding

class ProfilFragment : Fragment() {
    lateinit var binding : FragmentProfilBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentProfilBinding.inflate(inflater, container, false)

        binding.btnKeluar.setOnClickListener {
            logOut()

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireContext().getSharedPreferences("user",Context.MODE_PRIVATE)
        val nama = sharedPreferences.getString("Nama","")
        val emial = sharedPreferences.getString("Email","")
        val uname = sharedPreferences.getString("User","")
        binding.emailProfil.text = "Email :" + emial
        binding.namaProfil.text = "Nama :" + nama
        binding.uProfil.text = "Username :" + uname
    }
    fun logOut(){
        sharedPreferences.edit().clear()
        sharedPreferences.edit().apply()
        findNavController().navigate(R.id.action_profilFragment2_to_loginFragment2)
        Toast.makeText(context, "Anda Berhasil keluar", Toast.LENGTH_SHORT).show()
    }
}