package com.mirkhusainov.geekbrainscourse.presenter

import com.mirkhusainov.geekbrainscourse.model.CountersModel

class CounterInteractor : CounterContract.Presenter {
    private val counters = CountersModel

    override fun onClick(indexOfButton: Int) {
        when (indexOfButton) {
            1 -> increaseValue(1)
            2 -> increaseValue(2)
            3 -> increaseValue(3)
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