package com.example.practica5.sealed

import com.example.practica5.model.Country

sealed class DataState{
    class Success(val data:MutableList<Country>):DataState()
    class Failure(val message:String):DataState()
    data object Loading:DataState()
    data object Empty:DataState()
}