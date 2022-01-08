package com.example.tokoroti.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BarangResponse(
    @Expose
    @SerializedName("code")
    val code: Int,

    @Expose
    @SerializedName("message")
    val message: String,

    @Expose
    @SerializedName("errors")
    val errors: Any,

    @Expose
    @SerializedName("data")
    val data: List<Barang>
)
