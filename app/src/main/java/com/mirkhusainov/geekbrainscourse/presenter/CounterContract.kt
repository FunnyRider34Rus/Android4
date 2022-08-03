package com.mirkhusainov.geekbrainscourse.presenter

class CounterContract {

    interface View {
        fun showValue (index: Int)
    }

    interface Presenter {
        fun onClick(indexOfButton: Int)
        fun getData(index: Int): Int
    }
}