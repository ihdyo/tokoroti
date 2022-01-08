package com.example.tokoroti.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class BarangDataResponse(
    @field:SerializedName("data")
    val data: List<Barang>,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)

data class Barang(
    @Expose
    @SerializedName("id")
    val id: Int,

    @Expose
    @SerializedName("nama_barang")
    val nama: String,

    @Expose
    @SerializedName("kategori_barang")
    val kategori: String,

    @Expose
    @SerializedName("harga_barang")
    val harga: Int,

    @Expose
    @SerializedName("created_at")
    val created_at: Date,

    @Expose
    @SerializedName("updated_at")
    val data: Date
)
