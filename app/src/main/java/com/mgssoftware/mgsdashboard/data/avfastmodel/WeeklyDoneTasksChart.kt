package com.mgssoftware.mgsdashboard.data.avfastmodel


import com.google.gson.annotations.SerializedName

data class WeeklyDoneTasksChart(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("month")
    val month: String? = null,
    @SerializedName("users_count")
    val usersCount: Int? = null
)