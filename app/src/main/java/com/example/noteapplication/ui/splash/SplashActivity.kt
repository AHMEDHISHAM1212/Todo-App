package com.example.noteapplication.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.noteapplication.R
import com.example.noteapplication.ui.home.HomeActivity

class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startHomeActivity()
    }

    private fun startHomeActivity() {
        Handler(Looper.getMainLooper())
            .postDelayed({
                startActivity(Intent(this, HomeActivity::class.java))
            }
                ,2000)
    }
}