package com.benrostudios.lastmile.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.benrostudios.lastmile.data.models.User
import com.benrostudios.lastmile.data.network.response.ApiResponse

class AuthRepoImpl : AuthRepo, BaseRepository() {

    private val _apiResponse = MutableLiveData<ApiResponse>()

    override suspend fun registerUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun loginUser(user: User) {
        TODO("Not yet implemented")
    }

    override val networkError: LiveData<String>
        get() = _networkErrorResolution
    override val response: LiveData<ApiResponse>
        get() = _apiResponse
}