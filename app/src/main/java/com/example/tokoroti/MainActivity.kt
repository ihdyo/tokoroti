package com.example.tokoroti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tokoroti.api.ApiConfig
import com.example.tokoroti.api.ApiService
import com.example.tokoroti.api.adapter.BarangAdapter
import com.example.tokoroti.api.model.BarangDataRequest
import com.example.tokoroti.api.model.BarangResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val Menu = findViewById<RecyclerView>(R.id.rv_menu)

        with(Menu){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mainAdapter
        }

    }

    fun READ(view: View) {
        val retro = ApiConfig().getRetroClientInstance().create(ApiService::class.java)
        retro.getBarang().enqueue(object : Callback<BarangResponse> {
            override fun onResponse(call: Call<BarangResponse>, response: Response<BarangResponse>) {
                if (response.isSuccessful){
                    val Barang = response.body()!!
                    Menu = view.findViewById(R.id.rv_menu)
                    Menu.setHasFixedSize(true)
                    Menu.layoutManager = LinearLayoutManager(activity)
                    val BarangAdapter = BarangAdapter(Barang.data)
                    Menu.adapter = BarangAdapter
                    BarangAdapter.notifyDataSetChanged()
                }else{
                    Log.e("Error Code : ", response.code().toString())
                    Log.e("Error Message :", response.message().toString())
                }
            }
            override fun onFailure(call: Call<BarangResponse>, t: Throwable) {
                Log.e("Failed", t.message.toString())
            }
        })
    }

    fun CREATE(){
        var BarangDataRequest = BarangDataRequest(Nama.text.toString())

        val retro = ApiConfig().getRetroClientInstance().create(ApiService::class.java)
        retro.postBarang(BarangDataRequest).enqueue(object : Callback<BarangResponse> {
            override fun onResponse(call: Call<BarangResponse>, response: Response<BarangResponse>) {
                if (response.isSuccessful){
                    val Barang = response.body()!!
                    if (Barang.code==200){
                        Nama.setText("")
                    }
                    Toast.makeText(view!!.context,"Tambah Barang "+Barang.message.toString(), Toast.LENGTH_SHORT).show()
                }else{
                    Log.e("Error Code : ", response.code().toString())
                    Log.e("Error Message : ", response.message().toString())
                }
            }
            override fun onFailure(call: Call<BarangResponse>, t: Throwable) {
                Log.e("Failed", t.message.toString())
            }

        })
    }

    fun UPDATE(){
        var BarangDataRequest = BarangDataRequest(Nama.text.toString())

        val retro = ApiConfig().getRetroClientInstance().create(ApiService::class.java)
        retro.putBarang(Id.text.toString().toInt(),BarangDataRequest).enqueue(object : Callback<BarangResponse> {
            override fun onResponse(call: Call<BarangResponse>, response: Response<BarangResponse>) {
                if (response.isSuccessful){
                    val Barang = response.body()!!
                    if (Barang.code==200){
                        Id.setText("")
                        Nama.setText("")
                    }
                    Toast.makeText(view!!.context, "Update Barang "+Barang.message.toString(), Toast.LENGTH_SHORT).show()

                }else{
                    Log.e("Error Code : ", response.code().toString())
                    Log.e("Error Message : ", response.message().toString())
                }
            }

            override fun onFailure(call: Call<BarangResponse>, t: Throwable) {
                Log.e("Failed", t.message.toString())
            }

        })
    }

    fun DELETE(){

        val retro = ApiConfig().getRetroClientInstance().create(ApiService::class.java)
        retro.deleteBarang(Id.text.toString().toInt()).enqueue(object : Callback<BarangResponse> {
            override fun onResponse(call: Call<BarangResponse>, response: Response<BarangResponse>) {
                if (response.isSuccessful){
                    val Barang = response.body()!!
                    if (Barang.code==200){
                        Id.setText("")
                    }
                    Toast.makeText(view!!.context, "Delete Barang "+Barang.message.toString(), Toast.LENGTH_SHORT).show();
                }else{
                    Log.e("Error Code : ", response.code().toString())
                    Log.e("Error Message : ", response.message().toString())
                }
            }
            override fun onFailure(call: Call<BarangResponse>, t: Throwable) {
                Log.e("Failed", t.message.toString())
            }
        })
    }



}