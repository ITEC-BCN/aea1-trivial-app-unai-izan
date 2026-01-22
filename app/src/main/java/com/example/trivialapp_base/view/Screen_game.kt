package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.trivialapp_base.R
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val (buttonOne, buttonTwo, buttonThree, buttonFour, timeQuestion, edgyQuestion) = createRefs()
        Card(modifier = Modifier
            .size(150.dp)
            .constrainAs(edgyQuestion) {
                top.linkTo(parent.top, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text("Pregunta ${viewModel.indicePreguntaActual}: ${viewModel.preguntaActual}") }

        Button(
            onClick = {
                viewModel.responderPregunta(viewModel.respuestasMezcladas[0])
            },
            modifier = Modifier.constrainAs(buttonOne) {
                top.linkTo(edgyQuestion.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text(viewModel.respuestasMezcladas[0])
        }

        Button(
            onClick = {
                viewModel.responderPregunta(viewModel.respuestasMezcladas[1])
            },
            modifier = Modifier.constrainAs(buttonTwo) {
                top.linkTo(edgyQuestion.bottom, margin = 100.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text(viewModel.respuestasMezcladas[1])
        }

        Button(
            onClick = {
                viewModel.responderPregunta(viewModel.respuestasMezcladas[2])
            },
            modifier = Modifier.constrainAs(buttonThree) {
                top.linkTo(edgyQuestion.bottom, margin = 180.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text(viewModel.respuestasMezcladas[2])
        }

        Button(
            onClick = {
                viewModel.responderPregunta(viewModel.respuestasMezcladas[3])
            },
            modifier = Modifier.constrainAs(buttonFour) {
                top.linkTo(edgyQuestion.bottom, margin = 260.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text(viewModel.respuestasMezcladas[3])
        }

        if (viewModel.juegoTerminado) navController.navigate(Routes.ScrResult.route)
    }
}