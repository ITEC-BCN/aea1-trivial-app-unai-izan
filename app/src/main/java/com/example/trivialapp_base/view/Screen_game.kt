package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.trivialapp_base.R
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel
import androidx.compose.material3.ButtonDefaults?
@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    var optionSelected by remember { mutableStateOf("No selected") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val (buttonOne, buttonTwo,buttonTree, buttonFour, edgyQuestion, timeQuestion)= createRefs()

        Box(modifier = Modifier.size(100.dp).background(Color.White).constrainAs(buttonTree){
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
        })
        Box(modifier = Modifier.size(100.dp).background(Color.Red).constrainAs(buttonOne){
            top.linkTo(buttonTree.bottom)
            start.linkTo(parent.start)
        })
        Box(modifier = Modifier.size(100.dp).background(Color.Blue).constrainAs(buttonTwo){
            bottom.linkTo(buttonOne.bottom)
        })
        Box(modifier = Modifier.size(100.dp).background(Color.Green).constrainAs(buttonFour){
            bottom.linkTo(buttonTree.bottom)
        })

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier.constrainAs(buttonOne, ) {
                top.linkTo(buttonOne.bottom, margin = 10.dp) // Debajo del log
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text(text = "A")
        }


    }
}