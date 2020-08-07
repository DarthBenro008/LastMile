package com.benrostudios.lastmile.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.benrostudios.lastmile.data.models.User
import com.benrostudios.lastmile.data.network.response.ApiResponse
import com.benrostudios.lastmile.data.network.service.AuthService
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class AuthRepoImpl(
    private val authService: AuthService
) : AuthRepo, BaseRepository() {

    private val _apiResponse = MutableLiveData<ApiResponse>()

    override suspend fun registerUser(user: User, type: String) {
        val username: RequestBody = user.username.toRequestBody()
        val password: RequestBody = user.password.toRequestBody()
        val userType: RequestBody = type.toRequestBody()
        _apiResponse.postValue(
            safeApiCall(
                call = { authService.userRegistration(username, password, userType) },
                error = "Error registering user"
            )
        )
    }

    override suspend fun loginUser(user: User) {
        val username: RequestBody = user.username.toRequestBody()
        val password: RequestBody = user.password.toRequestBody()
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