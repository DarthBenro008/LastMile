package com.benrostudios.lastmile.ui.auth.signin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.benrostudios.lastmile.R
import com.benrostudios.lastmile.data.models.User
import com.benrostudios.lastmile.ui.base.ScopedFragment
import com.benrostudios.lastmile.ui.client.ClientActivity
import com.benrostudios.lastmile.ui.delivery.DeliveryActivity
import com.benrostudios.lastmile.utils.SharedPreferenceUtils
import com.benrostudios.lastmile.utils.errorSnackBar
import com.benrostudios.lastmile.utils.isValidAlphaNumeric
import kotlinx.android.synthetic.main.sign_in_fragment.*
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.viewmodel.ext.android.viewModel

class SignIn : ScopedFragment() {
    private val viewModel by viewModel<SignInViewModel>()
    private val sharedPreferenceUtils: SharedPreferenceUtils = get()

    companion object {
        fun newInstance() = SignIn()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_in_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        sign_in_button.setOnClickListener {
            validation()
            authListener()
//            startActivity(Intent(requireActivity(), ClientActivity::class.java))
//            requireActivity().finish()
        }
    }

    private fun validation() {
        if (sign_in_user_input.isValidAlphaNumeric("Username") && sign_in_password_input.isValidAlphaNumeric(
                "Password"
            )
        ) {
            loginUser(sign_in_user_input.text.toString(), sign_in_password_input.text.toString())
        }
    }

    private fun loginUser(username: String, password: String) = launch {
        viewModel.userSignIn(User(username, password))
    }

    private fun authListener() = launch {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            if (it.success) {
                sharedPreferenceUtils.userId = it.user_id
                sharedPreferenceUtils.userType = it.user_type
                val intent = if (it.user_type == "client") Intent(
                    requireActivity(),
                    ClientActivity::class.java
                ) else Intent(requireActivity(), DeliveryActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            } else {
                sing_in_fragment_container.errorSnackBar("Invalid Credentials!")
            }
        })

        viewModel.networkError.observe(viewLifecycleOwner, Observer {
            sing_in_fragment_container.errorSnackBar("$it")
        })
    }

}