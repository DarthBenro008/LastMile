package com.benrostudios.lastmile.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.benrostudios.lastmile.R
import com.benrostudios.lastmile.ui.auth.AuthActivity
import com.benrostudios.lastmile.ui.client.ClientActivity
import com.benrostudios.lastmile.utils.SharedPreferenceUtils
import org.koin.android.ext.android.get

class SplashActivity : AppCompatActivity() {
    private val sharedPreferenceUtils: SharedPreferenceUtils = get()

    private val SPLASH_TIME_OUT = 1000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    private fun initialize() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(
            {
                userCheck()
            }, SPLASH_TIME_OUT
        )
    }

    private fun userCheck() {
        if (sharedPreferenceUtils.userName.isNotEmpty()) {
            startActivity(Intent(this, ClientActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }
    }
}