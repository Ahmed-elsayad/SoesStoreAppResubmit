package com.udacity.shoesstoreapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoesstoreapp.models.Shoe

class ShoeViewModel : ViewModel(){

    // incapsulate the data source using the getter method to make our live data Immutable



    private val _shoesList = MutableLiveData<List<Shoe>>()

    val shoeItem = Shoe("adidas","44","adidas","good shoe")

    val shoesList: LiveData<List<Shoe>> get() = _shoesList
    init {
    }

    fun addShoe(){
        val list = _shoesList.value?.toMutableList() ?: mutableListOf()
  // using copy method from our data class
        list.add(shoeItem.copy())
        _shoesList.value = list

    }

}