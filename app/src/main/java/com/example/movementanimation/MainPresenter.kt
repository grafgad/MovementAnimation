package com.example.movementanimation

class MainPresenter {

    private var view: MainView? = null
    private var carPosition: CarAnimationState = CarAnimationState.Left

    fun bind(activity: MainActivity) {
        this.view = activity
    }

    fun unbind() {
        this.view = null
    }

    fun onButtonClicked(): CarAnimationState {
        carPosition = when (carPosition) {
            CarAnimationState.Start -> CarAnimationState.Top
            CarAnimationState.Top -> CarAnimationState.Right
            CarAnimationState.Right -> CarAnimationState.Bottom
            CarAnimationState.Bottom -> CarAnimationState.Left
            CarAnimationState.Left -> CarAnimationState.Top
        }

        return carPosition
    }

}