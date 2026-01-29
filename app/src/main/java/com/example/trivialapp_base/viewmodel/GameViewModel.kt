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
    var isCorrect by mutableStateOf(false)
    var showCorrection by mutableStateOf(false)
    private var preguntasPartida: List<Pregunta> = emptyList()

    private var counter:Int = 0

    var preguntasDisponibles = preguntasPartida.toMutableList()
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

    var lastTime by mutableFloatStateOf(1f)
        private set

    var juegoTerminado by mutableStateOf(false)
        private set

    var dificultadSeleccionada by mutableStateOf("Facil")
        private set

    private var timer: CountDownTimer? = null
    private val TIEMPO_POR_PREGUNTA = 10000L // 10 segons
    private val TIEMPO_CORRECCION = 1000L // 1 segon

    fun setDificultad(dificultad: String) {
        dificultadSeleccionada = dificultad // sense .value!
    }
    fun iniciarJuego() {
        counter = 0
        juegoTerminado = false
        indicePreguntaActual = 1
        puntuacion = 0
        val listOfQuestions = ProveedorPreguntas.obtenerPreguntas()
        preguntasPartida = listOfQuestions.filter{
                pregunta -> pregunta.dificultad == dificultadSeleccionada
        }
        preguntasDisponibles = preguntasPartida.toMutableList()
        cargarSiguientePregunta()
        iniciarTimer()
    }

    private fun cargarSiguientePregunta() {
        if (preguntasDisponibles.isEmpty()) {
            onCleared()
            return
        }
        val indexRandom = preguntasDisponibles.indices.random()
        preguntaActual = preguntasDisponibles.removeAt(indexRandom)

        respuestasMezcladas = listOf(
            preguntaActual!!.respuesta1,
            preguntaActual!!.respuesta2,
            preguntaActual!!.respuesta3,
            preguntaActual!!.respuesta4
        ).shuffled()
    }

    fun responderPregunta(respuestaUsuario: String) {
        while (counter < 1)
        {
            if (respuestaUsuario == preguntaActual!!.respuestaCorrecta)
            {
                isCorrect = true
                puntuacion += 10
            }
            else
            {
                isCorrect = false
            }
            showCorrection = true
            iniciarTimerCorreccion()
            counter++
        }

    }

    private fun avanzarRonda() {
        counter = 0
        indicePreguntaActual++
        if (indicePreguntaActual > 10)
        {
            onCleared()
            return
        }
        cargarSiguientePregunta()
        showCorrection = false
        iniciarTimer()
    }

    private fun iniciarTimer() {
        timer?.cancel()

        timer = object : CountDownTimer(TIEMPO_POR_PREGUNTA, 50) {

            override fun onTick(millisUntilFinished: Long) {
                tiempoRestante = (millisUntilFinished.toFloat() / TIEMPO_POR_PREGUNTA)
                lastTime = tiempoRestante
            }

            override fun onFinish() {
                tiempoRestante = 0f
                isCorrect = false
                iniciarTimerCorreccion()
            }
        }.start()
    }

    private fun iniciarTimerCorreccion() {
        timer?.cancel()

        timer = object : CountDownTimer(TIEMPO_CORRECCION, 50) {

            override fun onTick(millisUntilFinished: Long) {
                tiempoRestante = lastTime
            }

            override fun onFinish() {
                avanzarRonda()
            }
        }.start()
    }

    override fun onCleared() {
        counter = 0
        showCorrection = false
        timer?.cancel()
        preguntasPartida = emptyList()
        preguntasDisponibles.clear()
        indicePreguntaActual = 0
        juegoTerminado = true
    }
}
