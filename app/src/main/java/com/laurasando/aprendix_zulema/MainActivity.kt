package com.laurasando.aprendix_zulema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRegistro = findViewById<Button>(R.id.btn_registro)

        btnRegistro.setOnClickListener{
        val intent = Intent(this, Registro_usuarios::class.java)
            startActivity(intent)
        }

    }
}