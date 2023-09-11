package com.test

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ButtonsViewModel @Inject constructor(
    private val gameData: GameData
) : ViewModel() {
    val isBtn1Clicked = gameData.isBtn1Clicked
    val isBtn2Clicked = gameData.isBtn2Clicked
    val isBtn3Clicked = gameData.isBtn3Clicked

    fun onBtn1Click() {
        gameData.onBtn1Clicked()
    }

    fun onBtn2Click() {
        gameData.onBtn2Clicked()
    }

    fun onBtn3Click() {
        gameData.onBtn3Clicked()
    }
}