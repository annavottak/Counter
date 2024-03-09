package com.example.first

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue


class Counter {
    var number by mutableIntStateOf(0)
    fun add(){number++}
    fun reset(){number=0}
    fun remove(){number--}
}