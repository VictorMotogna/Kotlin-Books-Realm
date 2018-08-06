package com.victormotogna.favereads.activities

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.mcxiaoke.koi.ext.delayed
import com.mcxiaoke.koi.ext.startActivity
import com.victormotogna.favereads.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.delayed(2500) { startActivity<StartActivity>() }

    }
}
