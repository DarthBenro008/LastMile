package com.benrostudios.lastmile.data.network.response

data class UserResponse(
    val user_type: String,
    val user_id: Int,
    val success: Boolean,
    val status: String,
    val error: String
) {
    constructor() : this("", 0, false, "", "")

}