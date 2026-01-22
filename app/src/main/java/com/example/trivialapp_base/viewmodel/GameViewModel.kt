package com.example.trivialapp_base.viewmodel

import android.R
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
    var isCorrect: Boolean = false
    private var preguntasPartida: List<Pregunta> = emptyList()
    var indicePreguntaActual by mutableIntStateOf(1)
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

    var dificultadSeleccionada by mutableStateOf("Facil")
        private set

    private var timer: CountDownTimer? = null
    private val TIEMPO_POR_PREGUNTA = 10000L // 10 segons

    fun setDificultad(dificultad: String) {
        dificultadSeleccionada = dificultad // sense .value!
    }
    fun iniciarJuego() {
        juegoTerminado = false
        indicePreguntaActual = 1
        puntuacion = 0
        val listOfQuestions = ProveedorPreguntas.obtenerPreguntas()
        preguntasPartida = listOfQuestions.filter{
                pregunta -> pregunta.dificultad == dificultadSeleccionada
        }
        cargarSiguientePregunta()
        iniciarTimer()
    }

    private fun cargarSiguientePregunta() {
        preguntaActual = preguntasPartida.random()
        respuestasMezcladas = listOf<String>(preguntaActual!!.respuesta1, preguntaActual!!.respuesta2, preguntaActual!!.respuesta3, preguntaActual!!.respuesta4)
        respuestasMezcladas = respuestasMezcladas.shuffled()
    }

    fun responderPregunta(respuestaUsuario: String) {
        if (respuestaUsuario == preguntaActual!!.respuestaCorrecta)
        {
            isCorrect = true
            puntuacion += 10
        }
        else
        {
            isCorrect = false
        }
        avanzarRonda()
    }

    private fun avanzarRonda() {
        indicePreguntaActual++
        if (indicePreguntaActual >= 10)
        {
            onCleared()
            return
        }
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
        timer?.cancel()
        preguntasPartida = emptyList()
        indicePreguntaActual = 0
        juegoTerminado = true
    }
}
