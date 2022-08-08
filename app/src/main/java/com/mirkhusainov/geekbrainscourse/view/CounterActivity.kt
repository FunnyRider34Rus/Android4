package com.mirkhusainov.geekbrainscourse.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mirkhusainov.geekbrainscourse.databinding.ActivityCountersBinding
import com.mirkhusainov.geekbrainscourse.model.CountersModel
import com.mirkhusainov.geekbrainscourse.presenter.CounterContract
import com.mirkhusainov.geekbrainscourse.presenter.CounterInteractor

class CounterActivity : AppCompatActivity(), CounterContract.View {

    private lateinit var binding: ActivityCountersBinding
    private var presenter: CounterContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            setAllValues(CountersModel.getAllValues())
        }

        presenter = restoreInstance()
        presenter?.onAttach(this)

        with(binding) {
            button1.setOnClickListener {
                presenter?.onClick(0)

            }
            button2.setOnClickListener {
                presenter?.onClick(1)
            }
            button3.setOnClickListener {
                presenter?.onClick(2)
            }
        }
    }

    override fun setValue(index: Int, value: String) {
        with(binding) {
            when (index) {
                0 -> counter1.text = value
                1 -> counter2.text = value
                2 -> counter3.text = value
            }
        }
    }

    override fun setAllValues(values: List<Int>) {
        with(binding) {
            counter1.text = values[0].toString()
            counter2.text = values[1].toString()
            counter3.text = values[2].toString()
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