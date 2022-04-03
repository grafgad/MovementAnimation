package com.example.movementanimation

import android.view.View
import android.view.ViewTreeObserver

fun View.onLayout(callback: () -> Unit) {
    if (this.viewTreeObserver.isAlive) {
        this.viewTreeObserver.addOnGlobalLayoutListener(
            object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    callback()
                    this@onLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }
            })
    }
}