package com.benrostudios.lastmile.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.benrostudios.lastmile.data.models.RequestOrder
import com.benrostudios.lastmile.data.network.response.ApiResponse
import com.benrostudios.lastmile.data.network.response.Order
import com.benrostudios.lastmile.data.network.service.ClientService
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class ClientRepoImpl(
    private val clientService: ClientService
) : ClientRepo, BaseRepository() {

    private val _ordersList = MutableLiveData<List<Order>>()
    private val _createResponse = MutableLiveData<ApiResponse>()
    override val networkError
        get() = _networkErrorResolution

    override suspend fun createOrder(order: RequestOrder) {
        val clientId: RequestBody = order.client_id.toString().toRequestBody()
        val title: RequestBody = order.item_title.toRequestBody()
        val desc: RequestBody = order.item_description.toRequestBody()
        val pickup: RequestBody = order.pick_up_address.toRequestBody()
        val drop: RequestBody = order.drop_address.toRequestBody()
        _createResponse.postValue(
            safeApiCall(
                call = { clientService.orderPackage(clientId, pickup, drop, desc, title) },
                error = "Error in creating Order!"
            )
        )
    }

    override suspend fun fetchOrder(clientId: Int) {
        _ordersList.postValue(
            safeApiCall(
                call = { clientService.getPackageDetails(clientId) },
                error = "Error fetching Orders!"
            )
        )
    }

    override val ordersResponse: LiveData<List<Order>>
        get() = _ordersList
    override val createOrderResponse: LiveData<ApiResponse>
        get() = _createResponse

    override suspend fun deleteOrder(orderId: Int) {
        TODO("Not yet implemented")
    }
}