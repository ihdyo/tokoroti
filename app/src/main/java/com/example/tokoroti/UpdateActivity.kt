package com.example.tokoroti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tokoroti.api.ApiConfig
import com.example.tokoroti.api.ApiService
import com.example.tokoroti.api.model.BarangDataRequest
import com.example.tokoroti.api.model.BarangResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateActivity : AppCompatActivity() {

    lateinit var Nama: EditText
    lateinit var Kategori: EditText
    lateinit var Harga: EditText
    lateinit var Deskripsi: EditText
    lateinit var Kembali: Button
    lateinit var Edit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        Nama = findViewById(R.id.et_nama)
        Kategori = findViewById(R.id.et_kategori)
        Harga = findViewById(R.id.et_harga)
        Deskripsi = findViewById(R.id.et_deskripsi)
        Kembali = findViewById(R.id.btn_kembali)
        Edit = findViewById(R.id.btn_edit)

        Kembali.setOnClickListener {
            finish()
        }

        Edit.setOnClickListener {
//            TODO(Masukin logika UPDATE)
//            TODO(Tampilin TOAST)
            finish()
        }

//        TODO(Tampilkan Data Yang Akan Diedit)

    }


//    fun UPDATE(){
//        var BarangDataRequest = BarangDataRequest(Nama.text.toString())
//
//        val retro = ApiConfig().getRetroClientInstance().create(ApiService::class.java)
//        retro.putBarang(Id.text.toString().toInt(),BarangDataRequest).enqueue(object :
//            Callback<BarangResponse> {
//            override fun onResponse(call: Call<BarangResponse>, response: Response<BarangResponse>) {
//                if (response.isSuccessful){
//                    val Barang = response.body()!!
//                    if (Barang.code==200){
//                        Id.setText("")
//                        Nama.setText("")
//                    }
//                    Toast.makeText(view!!.context, "Update Barang "+Barang.message.toString(), Toast.LENGTH_SHORT).show()
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
