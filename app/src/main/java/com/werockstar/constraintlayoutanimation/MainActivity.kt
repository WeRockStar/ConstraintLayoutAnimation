package com.werockstar.constraintlayoutanimation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn01.setOnClickListener {
            startActivity(Intent(this, Example01Activity::class.java))
        }
        btn02.setOnClickListener {
            startActivity(Intent(this, Example02Activity::class.java))
        }
    }
}
