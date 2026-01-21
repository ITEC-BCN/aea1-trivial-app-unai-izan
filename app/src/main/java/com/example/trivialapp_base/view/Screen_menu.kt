package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
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
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.trivialapp_base.R
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun MenuScreen(navController: NavController, viewModel: GameViewModel) {
    var optionSelected by remember { mutableStateOf("No selected") }

    ConstraintLayout(
        modifier = Modifier
        .fillMaxSize()
            .background(Color.Black)
    ) {
        val (logoRef, playBtn, difficultPack) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.title),
            contentDescription = "Main title",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(300.dp)
                .constrainAs(logoRef) {
                    top.linkTo(parent.top, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Button(
            onClick = {
                viewModel.iniciarJuego()
                navController.navigate(Routes.ScrGame.route)
                      },
                modifier = Modifier.constrainAs(playBtn) {
                top.linkTo(logoRef.bottom, margin = 20.dp) // Debajo del logo
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text(text = "Play")
        }

        var selectedText: String by remember { mutableStateOf("Dificultat") }
        var expanded: Boolean by remember { mutableStateOf(false) }
        val difficulties = listOf("Easy", "Medium", "Hard", "Edgy")

        Column(
            modifier = Modifier.constrainAs(difficultPack)
            {
                top.linkTo(playBtn.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {


            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true }
                    .background(Color.White)
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    // Afegir colors i detalls al desplegable:
                    .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
            ) {
                difficulties.forEach { difficulty ->
                    DropdownMenuItem(
                        text = { Text(text = difficulty) },
                        onClick = {
                            expanded = false
                            selectedText = difficulty
                            viewModel.setDificultad(selectedText);
                        })
                }}}}

}

