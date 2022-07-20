package com.udacity.shoesstoreapp.fragments


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoesstoreapp.R
import com.udacity.shoesstoreapp.ShoeViewModel
import com.udacity.shoesstoreapp.databinding.FragmentShoeListBinding
import com.udacity.shoesstoreapp.databinding.ShoeItemBinding


class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    private val viewModel: ShoeViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container,false)

   //  we need to tell Android that our shoesListFragment has a menu
        setHasOptionsMenu(true)

        viewModel.shoeData.
        forEach {
            val itemBinding: ShoeItemBinding = ShoeItemBinding.inflate(layoutInflater, container,false)

//            val shoeItem = LayoutInflater.from(context).inflate(R.layout.shoe_item, binding.linearLayout, false)
            itemBinding.shoeName.text = it.name
            itemBinding.shoeSize.text = it.size
            itemBinding.shoeCompany.text = it.company
            itemBinding.shoeDescription.text = it.description
            binding.linearLayout.addView(itemBinding.root)



        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener {
            val action = ShoeListFragmentDirections.actionShoeListFragmentToDetailFragment2()
            findNavController().navigate(action)
        }
          // mapping the the views in shoe item with data provided by the k=live data


    }


    //we need to override onCreateOptionsMenu and inflate our new menu resource using the provided menu inflater and menu structure

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout, menu)
    }

    //we need to override onOptionsItemSelected to connect it to our NavigationUI

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        requireView().findNavController()
            .navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment2())
        return true
    }



}
