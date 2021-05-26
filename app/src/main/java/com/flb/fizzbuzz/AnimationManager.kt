package com.flb.fizzbuzz

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.view.View
import androidx.interpolator.view.animation.FastOutSlowInInterpolator

class AnimationManager {
    companion object {
        fun scaleReverseForEver(view: View) {
            val scalex = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.2f)
            val scaley = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.2f)
            val anim = ObjectAnimator.ofPropertyValuesHolder(view, scalex, scaley)
            anim.repeatCount = ValueAnimator.INFINITE
            anim.repeatMode = ValueAnimator.REVERSE
            anim.duration = 700
            anim.start()
        }

        fun animateToAlpha(view: View, alphaValue: Float) {
            view.animate()
                .setDuration(300)
                .setInterpolator(FastOutSlowInInterpolator())
                .alpha(alphaValue)
                .start()
        }
    }
}