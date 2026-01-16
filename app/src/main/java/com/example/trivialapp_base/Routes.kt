package com.example.trivialapp_base

sealed class Routes(val route: String) {
    object ScrMainMenu:Routes("mainmenu")
    object ScrGame:Routes("game")
    object ScrResult:Routes("result")
    object ScrSplash:Routes("splash")
}