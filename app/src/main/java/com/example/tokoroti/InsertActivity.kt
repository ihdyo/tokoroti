package com.example.tokoroti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

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
//            TODO(Masukin logika INSERT)
//            TODO(Tampilin TOAST)
            finish()
        }

    }


//    fun CREATE(){
//        var BarangDataRequest = BarangDataRequest(Nama.text.toString())
//
//        val retro = ApiConfig().getRetroClientInstance().create(ApiService::class.java)
//        retro.postBarang(BarangDataRequest).enqueue(object : Callback<BarangResponse> {
//            override fun onResponse(call: Call<BarangResponse>, response: Response<BarangResponse>) {
//                if (response.isSuccessful){
//                    val Barang = response.body()!!
//                    if (Barang.code==200){
//                        Nama.setText("")
//                    }
//                    Toast.makeText(view!!.context,"Tambah Barang "+Barang.message.toString(), Toast.LENGTH_SHORT).show()
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
