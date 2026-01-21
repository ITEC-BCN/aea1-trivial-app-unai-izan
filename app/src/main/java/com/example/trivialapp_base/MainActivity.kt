package com.example.trivialapp_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trivialapp_base.ui.theme.TrivialAPP_BaseTheme
import com.example.trivialapp_base.view.GameScreen
import com.example.trivialapp_base.view.MenuScreen
import com.example.trivialapp_base.view.ResultScreen
import com.example.trivialapp_base.view.SplashScreen
import com.example.trivialapp_base.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            TrivialAPP_BaseTheme {
                // Instanciamos el ViewModel una vez
                val gameViewModel by viewModels<GameViewModel>()
                // Controlador de navegación
                val navigationController = rememberNavController()
                // Definición de rutas y navegación
                NavHost(
                    navController = navigationController,
                    startDestination = Routes.ScrMainMenu.route
                ) {
                    composable(Routes.ScrMainMenu.route) { MenuScreen(navigationController, gameViewModel) }
                    composable(Routes.ScrGame.route) { GameScreen(navigationController, gameViewModel)}
                    composable(Routes.ScrResult.route) { ResultScreen(navigationController, gameViewModel) }
                    composable(Routes.ScrSplash.route) { SplashScreen(navigationController) }
                }
            }
        }
    }
}

