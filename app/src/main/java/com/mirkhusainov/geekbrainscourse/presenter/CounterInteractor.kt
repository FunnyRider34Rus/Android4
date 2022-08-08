package com.mirkhusainov.geekbrainscourse.presenter

import com.mirkhusainov.geekbrainscourse.model.CountersModel

class CounterInteractor : CounterContract.Presenter {
    private val counters = CountersModel
    private var view: CounterContract.View? = null
    override fun onAttach(view: CounterContract.View) {
        this.view = view
    }

    override fun onClick(indexOfButton: Int) {
        when(indexOfButton) {
            0 -> {
                increaseValue(indexOfButton)
                view?.setValue(indexOfButton, counters.getValue(indexOfButton).toString())
            }
            1 -> {
                increaseValue(indexOfButton)
                view?.setValue(indexOfButton, counters.getValue(indexOfButton).toString())
            }
            2 -> {
                increaseValue(indexOfButton)
                view?.setValue(indexOfButton, counters.getValue(indexOfButton).toString())
            }
        }
    }

    override fun getAllValues() {
        view?.setAllValues(counters.getAllValues())
    }

    private fun increaseValue(index: Int) {
        val currentValue = counters.getValue(index)
        val newValue = currentValue + 1
        counters.setValue(index, newValue)
    }
}