package com.example.trivialapp_base.view

import android.R.attr.end
import android.R.attr.start
import android.R.attr.top
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
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
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent

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
        Box(
            modifier = Modifier.constrainAs(shareBtn) {
                top.linkTo(scoreRef.bottom, margin = 120.dp) // Debajo del score
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
                .height(150.dp)
                .width(200.dp)
                .background(colorResource(id = R.color.Ferrari_Red))
        ) { }
        Button(
            onClick = {
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier.constrainAs(shareBtn) {
                top.linkTo(scoreRef.bottom, margin = 120.dp) // Debajo del score
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {

            Text(text = "Share",
                fontFamily = FontFamily(Font(R.font.fugazone)))
        }

        Box(
            modifier = Modifier.constrainAs(menuBtn) {
                top.linkTo(shareBtn.bottom, margin = 20.dp)
                start.linkTo(parent.start, margin = 150.dp)
            }
                .height(150.dp)
                .width(200.dp)
                .background(colorResource(id = R.color.Ferrari_Red))
        ) {
            Button(
                onClick = {
                    viewModel.iniciarJuego()
                    navController.navigate(Routes.ScrMainMenu.route)

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent)
            ) {
                Text(
                    text = "Return to menu",
                    fontFamily = FontFamily(Font(R.font.fugazone))
                )
            }
        }

    }
}