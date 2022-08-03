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

        with(binding) {
            button1.setOnClickListener {
                presenter?.onClick(1)
            }
            button2.setOnClickListener {
                presenter?.onClick(2)
            }
            button3.setOnClickListener {
                presenter?.onClick(3)
            }
        }
    }

    override fun showValue(index: Int) {
        with(binding) {
            when (index) {
                1 -> counter1.text = presenter?.getData(index).toString()
                2 -> counter2.text = presenter?.getData(index).toString()
                3 -> counter3.text = presenter?.getData(index).toString()
            }
        }
    }

    private fun restoreInstance(): CounterInteractor {
        val presenter = lastCustomNonConfigurationInstance as? CounterInteractor
        return presenter ?: CounterInteractor()
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return presenter
    }
}