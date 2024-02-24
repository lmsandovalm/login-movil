package com.laurasando.aprendix_zulema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.laurasando.aprendix_zulema.basedatos.BdHelper

class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bdManager = BdHelper(this)
        val bd = bdManager.writableDatabase
        Toast.makeText(this, "BD CREADA", Toast.LENGTH_SHORT).show()

        val btnRegistro = findViewById<Button>(R.id.btn_registro)
        btnRegistro.setOnClickListener {
            val intent = Intent(this, Registro_usuarios::class.java)
            startActivity(intent)
        }

    }
 }