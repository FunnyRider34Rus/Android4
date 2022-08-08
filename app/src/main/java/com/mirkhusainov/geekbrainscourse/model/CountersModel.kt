package com.mirkhusainov.geekbrainscourse.model

object CountersModel {
    private val counters = mutableListOf(0, 0, 0)

    fun getValue(index: Int): Int {
        return counters[index]
    }

    fun getAllValues(): List<Int> {
        return counters
    }

    fun setValue(index: Int, value: Int) {
        counters[index] = value
    }
}