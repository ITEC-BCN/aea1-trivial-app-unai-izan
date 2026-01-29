package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.trivialapp_base.R
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel
@Composable
fun ResultScreen(navController: NavController, viewModel: GameViewModel) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val (titleRef, scoreRef, menuBtn, shareBtn) = createRefs()

        //Score title
        Image(
            painter = painterResource(id = R.drawable.yourscore),
            contentDescription = "Score text",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(300.dp)
                .constrainAs(titleRef) {
                    top.linkTo(parent.top, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Card(modifier = Modifier.constrainAs(scoreRef) {
            top.linkTo(titleRef.bottom, margin = 20.dp) // Debajo del score
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            val finalPuntuacion = viewModel.puntuacion
            Text("$finalPuntuacion",
                Modifier.background(color = Color.Black),
                fontFamily = FontFamily(Font(R.font.fugazone)),
                fontSize = 60.sp,
                color = Color.White)
        }

        //Share button
        Button(
            onClick = {
            },
            modifier = Modifier.constrainAs(shareBtn) {
                top.linkTo(scoreRef.bottom, margin = 120.dp) // Debajo del score
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text(text = "Share",
                fontFamily = FontFamily(Font(R.font.fugazone)))
        }

        Button(
            onClick = {
                viewModel.iniciarJuego()
                navController.navigate(Routes.ScrMainMenu.route)
            },
            modifier = Modifier.constrainAs(menuBtn) {
                top.linkTo(scoreRef.bottom, margin = 200.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text(text = "Return to menu",
                fontFamily = FontFamily(Font(R.font.fugazone)))
        }
    }
}