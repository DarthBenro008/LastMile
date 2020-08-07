package com.benrostudios.lastmile.ui.auth.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.benrostudios.lastmile.R
import com.benrostudios.lastmile.data.models.User
import com.benrostudios.lastmile.ui.base.ScopedFragment
import com.benrostudios.lastmile.ui.client.ClientActivity
import com.benrostudios.lastmile.ui.delivery.DeliveryActivity
import com.benrostudios.lastmile.utils.*
import kotlinx.android.synthetic.main.sign_in_fragment.*
import kotlinx.android.synthetic.main.sign_up_fragment.*
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.viewmodel.ext.android.viewModel

class SignUp : ScopedFragment() {
    private val viewModel by viewModel<SignUpViewModel>()
    private val sharedPreferenceUtils: SharedPreferenceUtils = get()
    private var isRegisteredClient: Boolean = false
    private lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    companion object {
        fun newInstance() = SignUp()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_up_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button2.setOnClickListener {
            validation()
            listen()
        }
    }


    private fun validation() {
        if (register_username.isValidAlphaNumeric("Username") && register_password.isValidAlphaNumeric(
                "Password"
            )
        ) {
            button2.hide()
            sign_up_progress.show()
            register(
                register_username.text.toString(),
                register_password.text.toString(),
                !client_btn.isSelected
            )
        }
    }


    private fun register(username: String, password: String, isClient: Boolean) = launch {
        isRegisteredClient = isClient
        viewModel.registerUser(User(username, password), if (isClient) "client" else "partner")

    }

    private fun listen() = launch {
        viewModel.responseCache.observe(viewLifecycleOwner, Observer {
            Log.d("RESPONSE CACHE", "$it")
            if (it.success) {
                requireContext().shortToaster("User Created Sucessfully!")
                navController.navigate(R.id.action_signUp_to_welcome)
            } else {
                sign_up_container.errorSnackBar("user already exists")
                button2.show()
                sign_up_progress.hide()
            }
        })
        viewModel.networkError.observe(viewLifecycleOwner, Observer {
            Log.d("RESPONSE CACHE", "error from frag: $it")
        })
    }

}