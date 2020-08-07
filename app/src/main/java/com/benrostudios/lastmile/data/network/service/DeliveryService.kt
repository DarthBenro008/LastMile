package com.benrostudios.lastmile.data.network.service

import com.benrostudios.lastmile.data.network.response.ApiResponse
import com.benrostudios.lastmile.utils.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DeliveryService {


    @GET
    fun getDeliveryStatus(): Response<ApiResponse>

    @GET
    fun getAllOrdersAvailable(): Response<ApiResponse>

    @GET
    fun getOrderDetails(): Response<ApiResponse>

    @GET
    fun generateQR(): Response<ApiResponse>

    companion object {
        operator fun invoke(): DeliveryService {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DeliveryService::class.java)
        }
    }
}