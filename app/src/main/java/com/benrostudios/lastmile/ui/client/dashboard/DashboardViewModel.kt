package com.benrostudios.lastmile.ui.client.dashboard

import androidx.lifecycle.ViewModel
import com.benrostudios.lastmile.data.models.RequestOrder
import com.benrostudios.lastmile.data.repository.ClientRepo

class DashboardViewModel(
    private val clientRepo: ClientRepo
) : ViewModel() {
    val ordersList
        get() = clientRepo.ordersResponse

    val networkError
    get() = clientRepo.networkError
    val createOrdersResponse
        get() = clientRepo.createOrderResponse

    suspend fun createOrder(order: RequestOrder) {
        clientRepo.createOrder(order)
    }

    suspend fun getOrders(clientId: Int) {
        clientRepo.fetchOrder(clientId)
    }
}