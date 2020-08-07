package com.benrostudios.lastmile.data.network.service

import com.benrostudios.lastmile.data.network.response.ApiResponse
import com.benrostudios.lastmile.utils.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ClientService {

    @POST
    fun orderPackage(): Response<ApiResponse>

    @GET
    fun verifyQR(): Response<ApiResponse>

    //Dynamic Link
    @PUT
    fun cancelOrder(): Response<ApiResponse>

    @GET()
    fun getPackageDetails(): Response<ApiResponse>

    companion object {
        operator fun invoke(): ClientService {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ClientService::class.java)
        }
    }
}