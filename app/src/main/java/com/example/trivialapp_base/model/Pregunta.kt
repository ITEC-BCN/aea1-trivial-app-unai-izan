package com.example.trivialapp_base.model

// Definición de la clase de datos Pregunta según requisitos
data class Pregunta(
    val pregunta: String,
    val categoria: String,
    val dificultad: String, // "Facil", "Medio", "Dificil"
    val respuesta1: String,
    val respuesta2: String,
    val respuesta3: String,
    val respuesta4: String,
    val respuestaCorrecta: String // Debe coincidir con una de las anteriores
)

// Objeto para simular la base de datos local (Hardcoded)
object ProveedorPreguntas {
    fun obtenerPreguntas(): MutableList<Pregunta> {
        return mutableListOf(
            Pregunta("¿Capital de Francia?", "Geografía", "Facil", "Madrid", "París", "Berlin", "Roma", "París"),
            Pregunta("¿Fórmula del agua?", "Ciencia", "Facil", "H2O", "CO2", "O2", "H2O2", "H2O"),
            Pregunta("¿Autor del Quijote?", "Literatura", "Facil", "Cervantes", "Quevedo", "Lope", "Góngora", "Cervantes"),
            Pregunta("¿Campeón mundial fútbol 2010?", "Deportes", "Facil", "Brasil", "Alemania", "España", "Italia", "España"),
            Pregunta("¿Qué animal dice 'miau'?", "General", "Facil", "Perro", "Vaca", "Gato", "Pájaro", "Gato"),
            Pregunta("¿Quién descubrió América en 1492?", "Historia", "Facil", "Cristóbal Colón", "Simón Bolívar", "Yo", "Julio César", "Cristóbal Colón"),
            Pregunta("¿En qué continente está Argentina?", "Geografía", "Facil", "Europa", "África", "América", "Asia", "América"),
            Pregunta("¿Qué mar separa Europa de África?", "Geografía", "Facil", "Mar Rojo", "Mar Mediterráneo", "Mar Negro", "Mar Caribe", "Mar Mediterráneo"),
            Pregunta("¿Qué imperio gobernó Hispania en la Antigüedad?", "Historia", "Facil", "Imperio Romano", "Imperio Azteca", "Imperio Inca", "Imperio Chino", "Imperio Romano"),
            Pregunta("¿Cuántas horas de sueño se recomiendan para un adulto?", "Ciencia", "Facil", "4-5 horas", "0 horas", "7-9 horas", "10-12 horas", "7-9 horas"),
//Medio
            Pregunta("¿Quién pintó la Mona Lisa?", "Arte", "Medio", "Picasso", "Van Gogh", "Da Vinci", "Dalí", "Da Vinci"),
            Pregunta("¿Planeta más grande?", "Ciencia", "Medio", "Tierra", "Marte", "Júpiter", "Saturno", "Júpiter"),
            Pregunta("¿Año descubrimiento América?", "Historia", "Medio", "1492", "1500", "1485", "1992", "1492"),
            Pregunta("¿Moneda de Japón?", "Economía", "Medio", "Yuan", "Won", "Yen", "Dólar", "Yen"),
            Pregunta("¿Hueso más largo del cuerpo?", "Anatomía", "Medio", "Fémur", "Tibia", "Húmero", "Radio", "Fémur"),
            Pregunta("¿Qué rol se encarga principalmente de colocar visión en el mapa?", "Videojuegos", "Media", "Top", "Jungla", "Soporte", "Mid", "Soporte"),
            Pregunta("¿Cuál es el objetivo principal para ganar una partida?", "Videojuegos", "Medio", "Matar al Barón", "Conseguir dragones", "Destruir el nexo", "Tener más asesinatos", "Destruir el nexo"),
            Pregunta("¿Cómo se llama la espada de Tanjiro en Demon Slayer?", "Anime", "Medio", "Katana Nichirin", "Tessaiga", "Zangetsu", "Excalibur", "Katana Nichirin"),
            Pregunta("¿Quién entrena a Gohan durante la saga Saiyajin?", "Anime", "Medio", "Goku", "Vegeta", "Piccolo", "Krillin", "Piccolo"),
            Pregunta("¿Qué organización caza demonios en Demon Slayer?", "Anime", "Medio", "Akatsuki", "Cuerpo de Exterminio de Demonios", "Shinsengumi", "Gotei 13", "Cuerpo de Exterminio de Demonios"),
//Dificil
            Pregunta("¿Elemento químico Au?", "Química", "Dificil", "Plata", "Oro", "Cobre", "Aluminio", "Oro"),
            Pregunta("¿Velocidad de la luz?", "Física", "Dificil", "300.000 km/s", "150.000 km/s", "1000 km/s", "Mach 1", "300.000 km/s"),
            Pregunta("¿Qué lenguaje se considera el primero de alto nivel?", "Informática", "Dificil", "C", "FORTRAN", "Assembly", "Pascal", "FORTRAN"),
            Pregunta("¿Cuál es el número atómico del osmio?", "Química", "Dificil", "74", "76", "78", "80", "76"),
            Pregunta("¿Qué matemático introdujo la notación moderna del cálculo integral?", "Matemáticas", "Dificil", "Newton", "Leibniz", "Euler", "Cauchy", "Leibniz"),
            Pregunta("¿Qué emperador romano promulgó el Edicto de Milán?", "Historia", "Dificil", "Nerón", "Constantino I", "Teodosio I", "Augusto", "Constantino I"),
            Pregunta("¿En qué año fue lanzado oficialmente League of Legends?", "Videojuegos", "Dificil", "2007", "2008", "2009", "2010", "2009"),
            Pregunta("¿Qué campeón es conocido como 'El Coloso de Hierro'?", "Videojuegos", "Dificil", "Nautilus", "Blitzcrank", "Mordekaiser", "Urgot", "Blitzcrank"),
            Pregunta("¿Qué alquimista creó la Piedra Filosofal en Amestris?", "Anime", "Dificil", "Van Hohenheim", "Padre", "Edward Elric", "Scar", "Padre"),
            Pregunta("¿Qué tipo de titán poseía Ymir Fritz?", "Anime", "Dificil", "Titán Colosal", "Titán Fundador", "Titán Mandíbula", "Titán de Ataque", "Titán Fundador")
        )
    }
}