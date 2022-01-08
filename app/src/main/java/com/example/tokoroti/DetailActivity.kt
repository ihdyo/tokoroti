package com.example.tokoroti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }


//    fun DELETE(){
//
//        val retro = ApiConfig().getRetroClientInstance().create(ApiService::class.java)
//        retro.deleteBarang(Id.text.toString().toInt()).enqueue(object : Callback<BarangResponse> {
//            override fun onResponse(call: Call<BarangResponse>, response: Response<BarangResponse>) {
//                if (response.isSuccessful){
//                    val Barang = response.body()!!
//                    if (Barang.code==200){
//                        Id.setText("")
//                    }
//                    Toast.makeText(view!!.context, "Delete Barang "+Barang.message.toString(), Toast.LENGTH_SHORT).show();
//                }else{
//                    Log.e("Error Code : ", response.code().toString())
//                    Log.e("Error Message : ", response.message().toString())
//                }
//            }
//            override fun onFailure(call: Call<BarangResponse>, t: Throwable) {
//                Log.e("Failed", t.message.toString())
//            }
//        })
//    }


}