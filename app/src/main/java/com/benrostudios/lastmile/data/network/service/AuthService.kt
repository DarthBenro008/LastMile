package com.benrostudios.lastmile.data.network.service

import com.benrostudios.lastmile.data.network.response.ApiResponse
import com.benrostudios.lastmile.data.network.response.UserResponse
import com.benrostudios.lastmile.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface AuthService {

    @Multipart
    @POST("/users/")
    suspend fun userRegistration(
        @Part("username") username: RequestBody,
        @Part("password") password: RequestBody,
        @Part("user_type") userType: RequestBody
    ): Response<ApiResponse>

    @Multipart
    @POST("/users/auth/")
    fun userLogin(
        @Part("username") username: RequestBody,
        @Part("password") password: RequestBody
    ): Response<UserResponse>

    companion object {
        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().also {
            it.level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        operator fun invoke(): AuthService {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AuthService::class.java)
        }
    }
}