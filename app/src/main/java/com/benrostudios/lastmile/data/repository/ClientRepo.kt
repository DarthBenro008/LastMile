package com.benrostudios.lastmile.data.repository

import androidx.lifecycle.LiveData
import com.benrostudios.lastmile.data.models.RequestOrder
import com.benrostudios.lastmile.data.network.response.ApiResponse
import com.benrostudios.lastmile.data.network.response.Order

interface ClientRepo {
    suspend fun createOrder(order: RequestOrder)
    suspend fun fetchOrder(clientId: Int)
    val ordersResponse: LiveData<List<Order>>
    val createOrderResponse: LiveData<ApiResponse>
    suspend fun deleteOrder(orderId: Int)
    val networkError: LiveData<String>
}