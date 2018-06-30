package com.example.androidanimations

import android.animation.AnimatorInflater
import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //using value animator
        val valueAnimatorCode = ValueAnimator.ofFloat(0f, 500f)

        with(valueAnimatorCode) {
            interpolator = AccelerateDecelerateInterpolator()
            duration = 1000
            addUpdateListener {
                val progress = it.animatedValue as Float
                textViewCode.translationY = progress
                textViewCode.translationX = progress/2
            }
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
            start()
        }

        //using xml
        val valueAnimatorXml = AnimatorInflater.loadAnimator(this, R.animator.value_animator) as ValueAnimator

        with(valueAnimatorXml) {
            addUpdateListener {
                val progress = it.animatedValue as Float
                textViewXml.translationY = progress
                textViewXml.translationX = (progress/2) * -1
            }
            start()
        }
    }
}
