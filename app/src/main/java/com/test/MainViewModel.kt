package com.test

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val gameData: GameData
) : ViewModel() {
    val isNewDayEnabled = gameData.isNewDayEnabled

    fun newDay() {
        gameData.newDay()
    }
}