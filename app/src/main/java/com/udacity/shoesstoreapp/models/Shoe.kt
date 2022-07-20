package com.udacity.shoesstoreapp.models


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    var name: String?,
    var company: String?,
    var size: String?,
    var description: String?,
) : Parcelable
