package com.benrostudios.lastmile.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.benrostudios.lastmile.R
import com.benrostudios.lastmile.ui.base.BaseActivity
import com.benrostudios.lastmile.utils.errorSnackBar
import com.benrostudios.lastmile.utils.shortToaster
import com.benrostudios.lastmile.utils.successSnackBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        val snack = Snackbar.make(auth_activity_container, "You are disconnected from network", Snackbar.LENGTH_INDEFINITE)
        snack.setBackgroundTint(resources.getColor(R.color.errorRed))
        networkState.observeForever {
            if(!it){
                snack.show()
            }else{
                snack.dismiss()
                auth_activity_container.successSnackBar("You are back online!")
            }
        }
    }
}