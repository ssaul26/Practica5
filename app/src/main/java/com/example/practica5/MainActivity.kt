package com.example.practica5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.practica5.ui.components.SetData
import com.example.practica5.ui.theme.Practica5Theme
import com.example.practica5.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    private val ViewModel: MainViewModel by viewModels()
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica5Theme {
                // A surface container using the 'background' color from the theme
                Column {
                    TopAppBar(title = {
                        Text(text = "Paises del Mundo")
                    },
                        Modifier.background(Color.Cyan))
                    SetData(viewModel = ViewModel)
                }
            }
        }
    }
}

