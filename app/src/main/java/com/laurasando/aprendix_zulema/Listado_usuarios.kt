package com.laurasando.aprendix_zulema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.laurasando.aprendix_zulema.basedatos.BdManager

class Listado_usuarios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_usuarios)

        val listUsuarios = findViewById<ListView>(R.id.lista_usuarios)
        val bdManager = BdManager(this)
        val dataCiudad = bdManager.listData()

        listUsuarios.setOnItemClickListener{ parent, view, position, id ->
            Toast.makeText(this, "Usuario Registrado " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
        }


    }
}