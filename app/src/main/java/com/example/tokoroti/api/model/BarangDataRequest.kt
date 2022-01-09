package com.example.tokoroti.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BarangDataRequest(
    @Expose
    @SerializedName("nama_barang")
    val nama: String,

    @Expose
    @SerializedName("kategori_barang")
    val kategori: String,

    @Expose
    @SerializedName("harga_barang")
    val harga: Int,

//    @Expose
//    @SerializedName("deskripsi_barang")
//    val deskripsi: Int
)
