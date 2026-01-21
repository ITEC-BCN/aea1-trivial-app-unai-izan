package com.example.trivialapp_base.viewmodel

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivialapp_base.model.Pregunta
import com.example.trivialapp_base.model.ProveedorPreguntas

class GameViewModel : ViewModel() {
    private var preguntasPartida: List<Pregunta> = emptyList()
    var indicePreguntaActual by mutableIntStateOf(0)
        private set

    var preguntaActual by mutableStateOf<Pregunta?>(null)
        private set

    var respuestasMezcladas by mutableStateOf<List<String>>(emptyList())
        private set

    var puntuacion by mutableIntStateOf(0)
        private set

    var tiempoRestante by mutableFloatStateOf(100f)
        private set

    var juegoTerminado by mutableStateOf(false)
        private set

    var dificultadSeleccionada by mutableStateOf("Easy")
        private set

    private var timer: CountDownTimer? = null
    private val TIEMPO_POR_PREGUNTA = 10000L // 10 segons

    fun setDificultad(dificultad: String) {
        dificultadSeleccionada = dificultad // sense .value!
    }
    fun iniciarJuego() {
        indicePreguntaActual = 1
        cargarSiguientePregunta()
        iniciarTimer()
    }

    private fun cargarSiguientePregunta() {
        var randomNumber = (0..9).random()
        var listOfQuestions = ProveedorPreguntas.obtenerPreguntas()
        when (dificultadSeleccionada)
        {
            "Easy" -> for (i in listOfQuestions)
                    {

                    }
        }
    }

    fun responderPregunta(respuestaUsuario: String) {
    }

    private fun avanzarRonda() {
        indicePreguntaActual++
        cargarSiguientePregunta()
        iniciarTimer()
    }

    private fun iniciarTimer() {
        timer?.cancel()

        timer = object : CountDownTimer(TIEMPO_POR_PREGUNTA, 50) {

            override fun onTick(millisUntilFinished: Long) {
                tiempoRestante = (millisUntilFinished.toFloat() / TIEMPO_POR_PREGUNTA) * 100
            }

            override fun onFinish() {
                tiempoRestante = 0f
                avanzarRonda()
            }
        }.start()
    }

    override fun onCleared() {
    }
}
