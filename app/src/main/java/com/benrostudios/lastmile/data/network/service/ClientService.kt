package com.benrostudios.lastmile.data.network.service

import com.benrostudios.lastmile.data.network.response.ApiResponse
import com.benrostudios.lastmile.data.network.response.Order
import com.benrostudios.lastmile.utils.Constants
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ClientService {

    @Multipart
    @POST
    fun orderPackage(
        @Part("client_id ") client_id: RequestBody,
        @Part("pick_up_address") pickup_address: RequestBody,
        @Part("drop_address") drop_address: RequestBody,
        @Part("item_description") item_description: RequestBody,
        @Part("item_title") item_title: RequestBody
    ): Response<ApiResponse>

    @GET
    fun verifyQR(
        @Query("client_id") client_id: Int
    ): Response<ApiResponse>

    //Dynamic Link
    @PUT
    fun cancelOrder(
        @Query("") orderId: Int
    ): Response<ApiResponse>

    @GET("/client/orders/")
    fun getPackageDetails(@Query("client_id") client_id: Int): Response<List<Order>>

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