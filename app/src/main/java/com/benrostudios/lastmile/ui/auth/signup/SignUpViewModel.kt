package com.benrostudios.lastmile.ui.auth.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benrostudios.lastmile.data.models.User
import com.benrostudios.lastmile.data.repository.AuthRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val authRepo: AuthRepo
) : ViewModel() {
    val networkError
        get() = authRepo.networkError

    val responseCache
        get() = authRepo.response


    suspend fun registerUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            authRepo.registerUser(user)
        }
    }
}