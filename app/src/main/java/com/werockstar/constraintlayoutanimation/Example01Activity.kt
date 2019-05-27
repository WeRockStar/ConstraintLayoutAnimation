package com.werockstar.constraintlayoutanimation

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.activity_example01.*

class Example01Activity : AppCompatActivity() {

    private val constraintSetPrevious = ConstraintSet()
    private val constraintSetNext = ConstraintSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example01)

        constraintSetPrevious.clone(constraintRoot)
        constraintSetNext.clone(this, R.layout.activity_example01_alt)

        var altLayout = false
        constraintRoot.setOnClickListener {
            val transition = ChangeBounds()
            transition.interpolator = LinearInterpolator()
            TransitionManager.beginDelayedTransition(constraintRoot, transition)

            val constraint = if (altLayout) constraintSetPrevious else constraintSetNext
            constraint.applyTo(constraintRoot)
            altLayout = !altLayout
        }
    }
}
