package com.benrostudios.lastmile.data.network.response

data class Order(
    val client_id: Int,
    val pick_up_address: String,
    val drop_address: String,
    val item_description: String,
    val item_title: String,
    val status: String,
    val order_id: Int,
    val partner_id: Int
) {
    constructor() : this(0, "", "", "", "", "", 0, 0)
}