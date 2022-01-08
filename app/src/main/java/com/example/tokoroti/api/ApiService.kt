package com.example.tokoroti.api

import com.example.tokoroti.api.model.BarangDataRequest
import com.example.tokoroti.api.model.BarangResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("barang")
    fun getBarang() : Call<BarangResponse>

    @POST("barang")
    fun postBarang(@Body req: BarangDataRequest) : Call<BarangResponse>

    @PUT("barang/{id}")
    fun putBarang(@Path("id") id: Int, @Body req: BarangDataRequest) : Call<BarangResponse>

    @DELETE("barang/{id}")
    fun deleteBarang(@Path("id") id: Int) : Call<BarangResponse>

}