package com.example.movementanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movementanimation.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(R.layout.activity_main), CoroutineScope, MainView {

    private lateinit var delegate: CarAnimationDelegate
    private lateinit var presenter: MainPresenter
    private val binding: ActivityMainBinding by viewBinding(CreateMethod.BIND)
    override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()


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
                launch {
                    delegate.onAnimate(presenter.onButtonClicked())
                    delay(2000)
                }
            }
        }
    }

    private fun firstMove() {
        delegate.onAnimate(CarAnimationState.Start)
    }

    override fun onDestroy() {
        cancel()
        super.onDestroy()
    }

    override fun onStop() {
        presenter.unbind()
        super.onStop()
    }


}