package com.werockstar.constraintlayoutanimation

import android.graphics.Interpolator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import kotlinx.android.synthetic.main.activity_example02.*

class Example02Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example02)
    }

    fun switchView(view: View) {
        val transition= ChangeBounds()
        transition.interpolator = FastOutSlowInInterpolator()
        transition.duration = 300
        TransitionManager.beginDelayedTransition(constraintRoot, transition)
        placeholder.setContentId(view.id)
    }
}
