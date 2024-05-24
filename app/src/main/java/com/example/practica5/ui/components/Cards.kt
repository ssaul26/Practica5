package com.example.practica5.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.practica5.model.Country

@Composable
fun CardItem(country: Country){
    Card(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            TextCountry(label = "Pais", title = country.pais)
            Spacer(modifier = Modifier.height(15.dp))
            TextCountry(label = "Bandera", title = "")
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentAlignment = Alignment.Center
            )
            {

                AsyncImage(model = country.bandera,
                    contentDescription =country.pais,
                    modifier = Modifier
                        .size(300.dp)

                )

            }
            Spacer(modifier = Modifier.height(22.dp))
            TextCountry(label = "Continente", title = country.continente )
            Spacer(modifier = Modifier.height(22.dp))
            TextCountry(label = "Poblacion en Millones", title = country.poblacion.toString())

        }

    }
}