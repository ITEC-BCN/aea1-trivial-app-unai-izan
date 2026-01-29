package com.example.trivialapp_base.view
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        val (buttonOne, buttonTwo, buttonThree, buttonFour, edgyQuestion, timer, round, correction) = createRefs()
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
                top.linkTo(parent.top, margin = 150.dp)
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
                top.linkTo(round.bottom, margin = 1.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }
            ,
            progress = {viewModel.tiempoRestante},
            color = Color.White,
            trackColor = Color.LightGray
        )

        //CORRECCIÓ

        if (viewModel.showCorrection)
        {
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(133.dp, 100.dp)
                    .background(color = Color.Black)
                    .constrainAs(correction) {
                        top.linkTo(timer.bottom, margin = 10.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }){
                if(viewModel.isCorrect)
                {
                    Text("Correct",
                        textDecoration = null,
                        fontFamily = FontFamily(Font(R.font.fugazone)),
                        color = Color.Green,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center
                    )
                }
                else
                {
                    Text("Incorrect",
                        textDecoration = null,
                        fontFamily = FontFamily(Font(R.font.fugazone)),
                        color = Color.Red,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        //RESPOSTES
        Box(modifier = Modifier
            .height(150.dp)
            .width(200.dp)
            .background(colorResource(id = R.color.Ferrari_Red))
            .constrainAs(buttonOne){
                bottom.linkTo(buttonThree.top, margin = 5.dp)
                start.linkTo(parent.start, margin = 5.dp)
        }
        ){
            Button(
                onClick = {
                  viewModel.responderPregunta(viewModel.respuestasMezcladas[0])
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxSize()
            ){
                Text(text = viewModel.respuestasMezcladas[0],
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
                onClick = {
                  viewModel.responderPregunta(viewModel.respuestasMezcladas[1])
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxSize()
            ){
                Text(text = viewModel.respuestasMezcladas[1],
                    color = Color.Black,
                    fontSize = 24.sp
                )
            }

        }

        Box(modifier = Modifier
            .height(150.dp)
            .width(200.dp)
            .background(colorResource(id = R.color.Orange_Soda))
            .constrainAs(buttonThree){
                bottom.linkTo(parent.bottom, margin = 5.dp)
                start.linkTo(parent.start, margin = 5.dp)
        }
        ){
            Button(
                onClick = {
                  viewModel.responderPregunta(viewModel.respuestasMezcladas[2])
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxSize()
            ){
                Text(text = viewModel.respuestasMezcladas[2],
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
                onClick = {
                  viewModel.responderPregunta(viewModel.respuestasMezcladas[3])
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.fillMaxSize(),
            ){
                Text(text = viewModel.respuestasMezcladas[3],
                    color = Color.Black,
                    fontSize = 24.sp

                )
            }

        }

        if (viewModel.juegoTerminado) navController.navigate(Routes.ScrResult.route)
    }
}