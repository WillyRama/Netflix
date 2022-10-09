package com.willyramad.netflix.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.willyramad.netflix.R
import com.willyramad.netflix.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    lateinit var binding : FragmentRegisterBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireContext().getSharedPreferences("User", Context.MODE_PRIVATE)
        binding.btnregis.setOnClickListener {
            regis()
            findNavController().navigate(R.id.action_registerFragment2_to_loginFragment2)

        }
    }
    fun regis() {
        var nama = binding.nama.text.toString()
        var email = binding.email.text.toString()
        var username = binding.user.text.toString()
        var password = binding.pass.text.toString()
        var ulangpass = binding.konfirmpass.text.toString()
        var eduser = sharedPreferences.edit()
        eduser.putString("User", username)
        eduser.putString("Nama", nama)
        eduser.putString("Email", email)
        eduser.putString("Pass", password)
        eduser.putString("Konfirmasi", ulangpass)
        if (nama.isEmpty() && email.isEmpty() && username.isEmpty() && password.isEmpty() && ulangpass.isEmpty()) {
            Toast.makeText(context, "isi data dengan benar", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.registerFragment2)
        } else {
            if (password == ulangpass) {
                eduser.apply()
                Toast.makeText(context, "Resgistrasi anda berhasil", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Pasword tidak sama!!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.registerFragment2)
            }
        }
    }
}