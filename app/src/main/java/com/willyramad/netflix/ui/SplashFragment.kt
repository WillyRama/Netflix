package com.willyramad.netflix.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.willyramad.netflix.R
import com.willyramad.netflix.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    lateinit var binding : FragmentSplashBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root

        val splash: Long = 300

        Handler(Looper.myLooper()!!).postDelayed({
            sharedPreferences = requireContext().getSharedPreferences("user",Context.MODE_PRIVATE)
            if (sharedPreferences.getString("Username","").equals("")){
                findNavController().navigate(R.id.action_splashFragment2_to_loginFragment2)
            }else{
                if (sharedPreferences.getString("Username","").equals(""))
                    findNavController().navigate(R.id.action_splashFragment2_to_homeFragment)
            }
        },splash)
        return view
    }
}