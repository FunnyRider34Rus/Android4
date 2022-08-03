package com.mirkhusainov.geekbrainscourse.presenter

class CounterContract {

    interface View {
        fun showValue (index: Int)
        fun showAllValue ()
    }

    interface Presenter {
        fun onClick(indexOfButton: Int)
        fun getData(index: Int): Int
    }
}