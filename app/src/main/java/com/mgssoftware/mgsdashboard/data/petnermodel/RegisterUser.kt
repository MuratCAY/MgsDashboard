package com.mgssoftware.mgsdashboard.data.petnermodel


import com.google.gson.annotations.SerializedName

data class RegisterUser(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("surname")
    val surname: String? = null
)