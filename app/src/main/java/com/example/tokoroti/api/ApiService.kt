package com.example.tokoroti.api

import com.example.tokoroti.api.model.BarangDataRequest
import com.example.tokoroti.api.model.KategoriResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("barang")
    fun getBarang() : Call<KategoriResponse>

    @POST("barang")
    fun postBarang(@Body req: BarangDataRequest) : Call<KategoriResponse>

    @PUT("barang/{id}")
    fun putBarang(@Path("id") id: Int, @Body req: BarangDataRequest) : Call<KategoriResponse>

    @DELETE("barang/{id}")
    fun deleteBarang(@Path("id") id: Int) : Call<KategoriResponse>

}