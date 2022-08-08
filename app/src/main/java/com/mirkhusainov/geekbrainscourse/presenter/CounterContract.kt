package com.mirkhusainov.geekbrainscourse.presenter

import kotlin.collections.List as List

class CounterContract {

    interface View {
        fun setValue (index: Int, value: String)
        fun setAllValues (values: List<Int>)
    }

    interface Presenter {
        fun onAttach(view: View)
        fun onClick(indexOfButton: Int)
        fun getAllValues()
    }
}