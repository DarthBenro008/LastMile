package com.benrostudios.lastmile.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.benrostudios.lastmile.data.models.User
import com.benrostudios.lastmile.data.network.response.ApiResponse
import com.benrostudios.lastmile.data.network.service.AuthService

class AuthRepoImpl(
    private val authService: AuthService
) : AuthRepo, BaseRepository() {

    private val _apiResponse = MutableLiveData<ApiResponse>()

    override suspend fun registerUser(user: User) {
        _apiResponse.postValue(
            //TODO: PASS USER OBJECT?
            safeApiCall(
                call = { authService.userLogin() },
                error = "Error registering user"
            )
        )
    }

    override suspend fun loginUser(user: User) {
        _apiResponse.postValue(
            //TODO: Pass User Object
            safeApiCall(
                call = { authService.userLogin() },
                error = "Error in login!"
            )
        )
    }

    override val networkError: LiveData<String>
        get() = _networkErrorResolution
    override val response: LiveData<ApiResponse>
        get() = _apiResponse
}