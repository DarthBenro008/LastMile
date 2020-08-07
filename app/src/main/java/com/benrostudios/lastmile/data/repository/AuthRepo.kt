package com.benrostudios.lastmile.data.repository

import androidx.lifecycle.LiveData
import com.benrostudios.lastmile.data.models.User
import com.benrostudios.lastmile.data.network.response.ApiResponse

interface AuthRepo {
    suspend fun registerUser(user: User)
    suspend fun loginUser(user: User)
    val networkError: LiveData<String>
    val response: LiveData<ApiResponse>
}