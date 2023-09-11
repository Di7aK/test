package com.test

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameData @Inject constructor() {
    private val _isBtn1Clicked: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isBtn1Clicked = _isBtn1Clicked.asStateFlow()
    private val _isBtn2Clicked: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isBtn2Clicked = _isBtn2Clicked.asStateFlow()
    private val _isBtn3Clicked: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isBtn3Clicked = _isBtn3Clicked.asStateFlow()

    val isNewDayEnabled = combine(isBtn1Clicked, isBtn2Clicked, isBtn3Clicked) { isBtn1Clicked, isBtn2Clicked, isBtn3Clicked ->
        isBtn1Clicked && isBtn2Clicked && isBtn3Clicked
    }

    fun onBtn1Clicked() {
        _isBtn1Clicked.value = true
    }

    fun onBtn2Clicked() {
        _isBtn2Clicked.value = true
    }

    fun onBtn3Clicked() {
        _isBtn3Clicked.value = true
    }

    fun newDay() {
        //какая-то логика

        _isBtn1Clicked .value = false
        _isBtn2Clicked .value = false
        _isBtn3Clicked .value = false
    }
}