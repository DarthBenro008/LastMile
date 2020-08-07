package com.benrostudios.lastmile.ui.auth.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benrostudios.lastmile.data.models.User
import com.benrostudios.lastmile.data.repository.AuthRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInViewModel(
    private val authRepo: AuthRepo
) : ViewModel() {

    val networkError
        get() = authRepo.networkError

    val response
        get() = authRepo.response

    suspend fun userSignIn(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            authRepo.loginUser(user)
        }
    }
}