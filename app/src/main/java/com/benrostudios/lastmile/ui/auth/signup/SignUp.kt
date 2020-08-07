package com.benrostudios.lastmile.ui.auth.signup

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.benrostudios.lastmile.R
import com.benrostudios.lastmile.data.models.User
import com.benrostudios.lastmile.ui.base.ScopedFragment
import kotlinx.android.synthetic.main.sign_in_fragment.*
import kotlinx.android.synthetic.main.sign_up_fragment.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class SignUp : ScopedFragment() {
    private val viewModel by viewModel<SignUpViewModel>()

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
            trial()
            listen()
        }
    }

    private fun trial() = launch {
        viewModel.registerUser(User("abc", "123"))
    }

    private fun listen() = launch {
        viewModel.responseCache.observe(viewLifecycleOwner, Observer {
            Log.d("RESPONSE CACHE","$it")
        })
        viewModel.networkError.observe(viewLifecycleOwner, Observer {
            Log.d("RESPONSE CACHE","error from frag: $it")
        })
    }

}