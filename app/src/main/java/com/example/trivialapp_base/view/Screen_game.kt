package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    var optionSelected by remember { mutableStateOf("No selected") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val (buttonOne, buttonTwo,buttonTree, buttonFour, edgyQuestion, timeQuestion)= createRefs()


        Box(modifier = Modifier
            .height(150.dp)
            .width(200.dp)
            .background(colorResource(id = R.color.Ferrari_Red))
            .constrainAs(buttonOne){
                bottom.linkTo(buttonTree.top, margin = 5.dp)
                start.linkTo(parent.start, margin = 5.dp)
        }
        ){
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxSize()
            ){
                Text(text = "A",
                    color = Color.Black,
                    fontSize = 24.sp
                )
            }

        }
        Box(modifier = Modifier
            .height(150.dp)
            .width(200.dp)
            .background(colorResource(id = R.color.card_ruf))
            .constrainAs(buttonTwo){
                bottom.linkTo(buttonFour.top, margin = 5.dp)
                end.linkTo(parent.end, margin = 5.dp)
        }
        ){
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxSize()
            ){
                Text(text = "A",
                    color = Color.Black,
                    fontSize = 24.sp
                )
            }

        }
        Box(modifier = Modifier
            .height(150.dp)
            .width(200.dp)
            .background(colorResource(id = R.color.Orange_Soda))
            .constrainAs(buttonTree){
                bottom.linkTo(parent.bottom, margin = 5.dp)
                start.linkTo(parent.start, margin = 5.dp)
        }
        ){
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxSize()
            ){
                Text(text = "A",
                    color = Color.Black,
                    fontSize = 24.sp
                )
            }

        }
        Box(modifier = Modifier
            .height(150.dp)
            .width(200.dp)
            .background(colorResource(id = R.color.car_color))
            .constrainAs(buttonFour){
                bottom.linkTo(parent.bottom,margin = 5.dp)
                end.linkTo(parent.end, margin = 5.dp )
        }
        ){
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.fillMaxSize(),
            ){
                Text(text = "ae",
                    color = Color.Black,
                    fontSize = 15.sp

                )
            }

        }
    }
}