package com.kou.thinkit.Screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kou.thinkit.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ic_home.setImageAsset("home.svg")

        btnContinue.setOnClickListener {
            if (edName.text.isNotEmpty())
                HomeActivity.start(this, edName.text.toString())
        }

    }
}