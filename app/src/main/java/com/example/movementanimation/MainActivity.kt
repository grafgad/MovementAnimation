package com.example.movementanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movementanimation.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(R.layout.activity_main), MainView {

    private lateinit var delegate: CarAnimationDelegate
    private lateinit var presenter: MainPresenter
    private val binding: ActivityMainBinding by viewBinding(CreateMethod.BIND)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        delegate = CarAnimationDelegate(binding.car, binding.parentView)
        presenter = MainPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.bind(this)
    }

    override fun onResume() {
        super.onResume()
        binding.car.onLayout {
            firstMove()
            binding.car.setOnClickListener {
                delegate.onAnimate(presenter.onButtonClicked())
            }
        }
    }

    private fun firstMove() {
        delegate.onAnimate(CarAnimationState.Start)
    }

    override fun onStop() {
        presenter.unbind()
        super.onStop()
    }


}