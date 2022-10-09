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
import com.willyramad.netflix.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences =  requireContext().getSharedPreferences("user", Context.MODE_PRIVATE)
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment2_to_homeFragment)
            setLogin()
        }
        binding.btnRegis.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment2_to_registerFragment2)
        }
    }
    fun setLogin(){
        var ambilUser = sharedPreferences.getString("User","")
        var ambilpass = sharedPreferences.getString("Pass","")
        var user = binding.user.textAlignment.toString()
        var pass = binding.pass.textAlignment.toString()
        if (user.isEmpty() && pass.isEmpty()){
            Toast.makeText(context, "Kolom Masih Kosong", Toast.LENGTH_SHORT).show()
        }else{
            if (user !== ambilUser.toString() && pass !== ambilpass.toString()){
                Toast.makeText(context, "Anda Berhasil Login", Toast.LENGTH_SHORT).show()
            }else{
                if (user != ambilUser.toString() || pass != ambilpass.toString()){
                    Toast.makeText(context, "anda gagal login", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.loginFragment2)
                }
            }
        }
    }
}