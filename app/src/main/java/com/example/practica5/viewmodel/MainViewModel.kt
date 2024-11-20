package com.example.practica5.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.practica5.model.Pokemon
import com.example.practica5.sealed.DataState
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainViewModel: ViewModel() {
    private val db = Firebase.firestore //singleton de firebase
    val response: MutableState<DataState> = mutableStateOf(DataState.Empty)
    init{
        fetchDataFromFirebase()
    }

    private fun fetchDataFromFirebase(){
        val tempList = mutableListOf<Pokemon>()
        response.value = DataState.Loading
        db.collection("Pokemons")
            .get()
            .addOnSuccessListener {
                    document ->

                for( dataSnap in document  ){

                    val movieItem = dataSnap.toObject(Pokemon::class.java)
                    Log.d("getFirebase",movieItem.Imagen.toString() ) //en consola
                    Log.d("getFirebase",movieItem.Nombre.toString())
                    Log.d("getFirebase",movieItem.Tipo.toString() )
                    Log.d("getFirebase",movieItem.NumerodePoquedex.toString() )
                    tempList.add(movieItem)
                }
                response.value = DataState.Success(tempList)



            }.addOnCanceledListener {
                response.value = DataState.Failure(error("Error"))
            }

    }

}