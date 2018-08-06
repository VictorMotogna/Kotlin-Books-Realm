package com.victormotogna.favereads.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mcxiaoke.koi.ext.onClick
import com.mcxiaoke.koi.ext.startActivity
import com.victormotogna.favereads.R
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        start.onClick { startActivity<BooksActivity>() }
    }
}