package com.udacity.shoesstoreapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoesstoreapp.R
import com.udacity.shoesstoreapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var  binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root
    }

     // using safe args to navigate from login screen to welcome screen
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.register.setOnClickListener{
            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment2()
            findNavController().navigate(action)
        }

        binding.login.setOnClickListener{
            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment2()
            findNavController().navigate(action)
        }
    }

}