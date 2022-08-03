package com.mirkhusainov.geekbrainscourse.presenter

import com.mirkhusainov.geekbrainscourse.model.CountersModel

class CounterInteractor : CounterContract.Presenter {
    private val counters = CountersModel

    override fun onClick(index: Int) {
        when (index) {
            0 -> increaseValue(index)
            1 -> increaseValue(index)
            2 -> increaseValue(index)
        }
    }

    override fun getData(index: Int): Int {
        return counters.getValue(index)
    }

    private fun increaseValue(index: Int) {
        val currentValue = counters.getValue(index)
        val updateValue = currentValue + 1
        counters.setValue(index, updateValue)
    }
}