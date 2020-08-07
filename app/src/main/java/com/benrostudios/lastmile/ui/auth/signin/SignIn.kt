package com.benrostudios.lastmile.ui.auth.signin

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.benrostudios.lastmile.R
import com.benrostudios.lastmile.data.models.User
import com.benrostudios.lastmile.ui.base.ScopedFragment
import com.benrostudios.lastmile.ui.client.ClientActivity
import kotlinx.android.synthetic.main.sign_in_fragment.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class SignIn : ScopedFragment() {
    private val viewModel by viewModel<SignInViewModel>()

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
            startActivity(Intent(requireActivity(), ClientActivity::class.java))
            requireActivity().finish()
        }
    }


}