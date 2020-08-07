package com.benrostudios.lastmile.data.models

data class RequestOrder(
    val client_id: Int,
    val pick_up_address: String,
    val drop_address: String,
    val item_description: String,
    val item_title: String
) {
    constructor() : this(0, "", "", "", "")
}