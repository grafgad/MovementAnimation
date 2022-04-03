package com.example.movementanimation

import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CarAnimationDelegate(
    private val car: View,
    private val parentView: View
) : CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    fun onAnimate(state: CarAnimationState) {
        val degree = 120f
        val carX = car.x
        val carY = car.y
        val parentX = parentView.x
        val parentY = parentView.y
        launch {
            when (state) {
                CarAnimationState.Start -> {
                    car.animate()
                        .translationX(parentX - carX)
                        .duration = 1000
                    delay(1000)
                    car.animate().rotation(degree)
                }
                CarAnimationState.Top -> {
                    car.animate()
                        .translationX(parentX)
                        .translationY(parentY - carY)
                        .duration = 1000
                    delay(1000)
                    car.animate().rotation(degree + 120)
                }
                CarAnimationState.Right -> {
                    car.animate()
                        .translationX(parentX + carX)
                        .translationY(parentY / 2)
                        .duration = 1000
                    delay(1000)
                    car.animate().rotation(degree + 180)
                }

                CarAnimationState.Bottom -> {
                    car.animate()
                        .translationX(parentX)
                        .translationY(parentY + carY)
                        .duration = 1000
                    delay(1000)
                    car.animate().rotation(degree + 300)
                }

                CarAnimationState.Left -> {
                    car.animate()
                        .translationX(parentX - carX)
                        .translationY(parentY / 2)
                        .duration = 1000
                    delay(1000)
                    car.animate().rotation(degree + 360)
                }
            }
        }
    }
}