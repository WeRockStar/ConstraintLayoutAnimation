package com.werockstar.constraintlayoutanimation

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_example01.*

class Example01Activity : AppCompatActivity() {

    private val constraintSetPrevious = ConstraintSet()
    private val constraintSetNext = ConstraintSet()
    private var altLayout = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example01)

        constraintSetPrevious.clone(constraint)
        constraintSetNext.clone(this, R.layout.activity_example01_alt)

        constraint.setOnClickListener {
            val transition = ChangeBounds()
            transition.interpolator = LinearInterpolator()
            TransitionManager.beginDelayedTransition(constraint, transition)

            if (altLayout) {
                constraintSetPrevious.applyTo(constraint)
                altLayout = false
            } else {
                constraintSetNext.applyTo(constraint)
                altLayout = true
            }
        }
    }
}
