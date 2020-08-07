package com.benrostudios.lastmile.data.network.service

import com.benrostudios.lastmile.data.network.response.ApiResponse
import com.benrostudios.lastmile.utils.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST

interface AuthService {

    @POST
    fun userRegistration(): Response<ApiResponse>

    @POST
    fun userLogin(): Response<ApiResponse>

    companion object {
        operator fun invoke(): AuthService {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AuthService::class.java)
        }
    }
}