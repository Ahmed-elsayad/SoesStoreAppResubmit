package com.udacity.shoesstoreapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoesstoreapp.R
import com.udacity.shoesstoreapp.databinding.FragmentInstructionBinding

class IstructionFragment : Fragment() {

    private lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         // using safe arges to navigate to shoesList fragment
        binding.next.setOnClickListener {
            val action = IstructionFragmentDirections.actionDescriptionFragmentToShoeListFragment2()
            findNavController().navigate(action)
        }
    }
}