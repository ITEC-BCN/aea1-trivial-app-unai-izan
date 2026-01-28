package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        val (buttonOne, buttonTwo, buttonThree, buttonFour, edgyQuestion, timer, round) = createRefs()
        //PREGUNTA
        Box(modifier = Modifier
            .fillMaxWidth(1f)
            .padding(50.dp, 100.dp)
            .background(color = Color.Black)
            .constrainAs(edgyQuestion) {
                top.linkTo(parent.top, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }){
            Text(viewModel.preguntaActual!!.pregunta,
                textDecoration = null,
                fontFamily = FontFamily(Font(R.font.fugazone)),
                color = Color.White,
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )
        }

        //RONDA
        Box(modifier = Modifier
            .fillMaxWidth(1f)
            .padding(176.dp, 100.dp)
            .background(color = Color.Black)
            .constrainAs(round) {
                top.linkTo(edgyQuestion.bottom, margin = -150.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text("${viewModel.indicePreguntaActual}/10",
                textDecoration = null,
                fontFamily = FontFamily(Font(R.font.fugazone)),
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            ) }

        //TIMER
        LinearProgressIndicator(
            modifier = Modifier
                .constrainAs(timer) {
                top.linkTo(edgyQuestion.bottom, margin = 0.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }
            ,
            progress = {viewModel.tiempoRestante},
            color = Color.White,
            trackColor = Color.LightGray
        )

        //RESPOSTES
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
            Text(viewModel.respuestasMezcladas[0],
                fontFamily = FontFamily(Font(R.font.fugazone)))
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
            Text(viewModel.respuestasMezcladas[1],
                fontFamily = FontFamily(Font(R.font.fugazone)))
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
            Text(viewModel.respuestasMezcladas[2],
                fontFamily = FontFamily(Font(R.font.fugazone)),)
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
            Text(viewModel.respuestasMezcladas[3],
                fontFamily = FontFamily(Font(R.font.fugazone)))
        }

        if (viewModel.juegoTerminado) navController.navigate(Routes.ScrResult.route)
    }
}