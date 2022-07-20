package com.udacity.shoesstoreapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoesstoreapp.models.Shoe

class ShoeViewModel : ViewModel(){

    // incapsulate the data source using the getter method to make our live data Immutable
    private val _shoeData = mutableListOf<Shoe>()
    val _name = MutableLiveData("")
    val _company = MutableLiveData("")
    val _size = MutableLiveData("")
    val _description = MutableLiveData("")
    val shoeData: List<Shoe> = _shoeData
    val name: LiveData<String> = _name
    val company: LiveData<String> = _company
    val size: LiveData<String> = _size
    val description: LiveData<String> = _description

    fun saveShoeData() {
        val newShoe = Shoe(name.value, company.value, size.value, description.value)
        _shoeData.add(newShoe)
    }
}