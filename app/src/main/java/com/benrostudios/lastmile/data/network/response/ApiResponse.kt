package com.benrostudios.lastmile.data.network.response

data class ApiResponse(
    val success: Boolean,
    val error: String,
    val msg: String
) {
    constructor() : this(false, "", "")
}