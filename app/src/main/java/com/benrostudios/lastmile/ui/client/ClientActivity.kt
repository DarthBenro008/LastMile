package com.benrostudios.lastmile.ui.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.benrostudios.lastmile.R
import kotlinx.android.synthetic.main.activity_client.*

class ClientActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)
        navController = findNavController(R.id.nav_host_fragment_home_activity)
        bottom_navigation_view_client_activity.setupWithNavController(navController)
    }
}