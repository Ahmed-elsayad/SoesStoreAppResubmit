package com.udacity.shoesstoreapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.udacity.shoesstoreapp.R
import com.udacity.shoesstoreapp.ShoeViewModel
import com.udacity.shoesstoreapp.databinding.FragmentDetailBinding
import kotlinx.coroutines.launch

class DetialFragment : Fragment() {


    //we need to create a binding object in detail fragment, to pass the data to the variable which we defined in XML layout and viewModel object as a data source for the Views.
    private lateinit var binding: FragmentDetailBinding
    private val viewModel: ShoeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false  )
        binding.shoeViewModel = viewModel
        binding.shoe = viewModel.shoeItem
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                // update our data source and navigate pack to shoe List fragment
                binding.addItem.setOnClickListener {
                    viewModel.addShoe()
                    val action = DetialFragmentDirections.actionDetailFragmentToShoeListFragment2()
                    findNavController().navigate(action)
                }
            }
        }
    }

}

