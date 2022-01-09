package com.example.tokoroti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tokoroti.api.ApiConfig
import com.example.tokoroti.api.model.BarangDataRequest
import com.example.tokoroti.api.model.BarangResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InsertActivity : AppCompatActivity() {

    lateinit var Nama: EditText
    lateinit var Kategori: EditText
    lateinit var Harga: EditText
    lateinit var Deskripsi: EditText
    lateinit var Kembali: Button
    lateinit var Tambahkan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        Nama = findViewById(R.id.et_nama)
        Kategori = findViewById(R.id.et_kategori)
        Harga = findViewById(R.id.et_harga)
        Deskripsi = findViewById(R.id.et_deskripsi)
        Kembali = findViewById(R.id.btn_kembali)
        Tambahkan = findViewById(R.id.btn_tambahkan)

        Kembali.setOnClickListener {
            finish()
        }

        Tambahkan.setOnClickListener {
            var nama = Nama.text.toString()
            var kategori = Kategori.text.toString()
            var harga = Harga.text.toString().toInt()
//            var deskripsi = Deskripsi.text.toString()

            var BarangDataRequest = BarangDataRequest(nama, kategori, harga)

            val retro = ApiConfig().getRetroClientInstance().postBarang(BarangDataRequest)
            retro.enqueue(object : Callback<BarangResponse> {
                override fun onResponse(call: Call<BarangResponse>, response: Response<BarangResponse>) {
                    if (response.isSuccessful){
                        val Barang = response.body()!!
                        if (Barang.code==200){
                            Nama.setText("")
                        }
                        Toast.makeText(this@InsertActivity, Barang.message + " berhasil ditambahkan", Toast.LENGTH_SHORT).show()
                    } else{
                        Log.e("Error Code : ", response.code().toString())
                        Log.e("Error Message : ", response.message().toString())
                    }
                }
                override fun onFailure(call: Call<BarangResponse>, t: Throwable) {
                    Log.e("Failed", t.message.toString())
                }
            })
            finish()
        }
    }

}
