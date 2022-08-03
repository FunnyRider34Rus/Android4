package com.mirkhusainov.geekbrainscourse.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mirkhusainov.geekbrainscourse.databinding.ActivityCountersBinding
import com.mirkhusainov.geekbrainscourse.presenter.CounterContract
import com.mirkhusainov.geekbrainscourse.presenter.CounterInteractor

class CounterActivity : AppCompatActivity(), CounterContract.View {

    private lateinit var binding: ActivityCountersBinding
    private var presenter: CounterContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = restoreInstance()

        if (savedInstanceState != null) showAllValue()
        with(binding) {
            button1.setOnClickListener {
                refreshView(0)
            }
            button2.setOnClickListener {
                refreshView(1)
            }
            button3.setOnClickListener {
                refreshView(2)
            }
        }
    }

    private fun refreshView(index: Int) {
        presenter?.onClick(index)
        showValue(index)
    }

    override fun showValue(index: Int) {
        with(binding) {
            when (index) {
                0 -> counter1.text = presenter?.getData(index).toString()
                1 -> counter2.text = presenter?.getData(index).toString()
                2 -> counter3.text = presenter?.getData(index).toString()
            }
        }
    }

    override fun showAllValue() {
        with(binding) {
            counter1.text = presenter?.getData(0).toString()
            counter2.text = presenter?.getData(1).toString()
            counter3.text = presenter?.getData(2).toString()
        }
    }

    private fun restoreInstance(): CounterInteractor {
        val presenter = lastCustomNonConfigurationInstance as? CounterInteractor
        return presenter ?: CounterInteractor()
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return presenter
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter = null
    }
}