package com.example.tokoroti.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BarangDataRequest(
    @Expose
    @SerializedName("nama_barang")
    var nama: String
)
