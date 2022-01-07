package com.mgssoftware.mgsdashboard.data.avfastmodel


import com.google.gson.annotations.SerializedName

data class DailyLoggedİnUsersChart(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("day")
    val day: String,
    @SerializedName("users_count")
    val usersCount: Int
)