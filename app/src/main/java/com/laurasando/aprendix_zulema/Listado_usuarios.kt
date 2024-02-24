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
        val dataUser = bdManager.listData()
        val adapterUser = ArrayAdapter(this,android.R.layout.simple_list_item_1,dataUser)
        listUsuarios.adapter=adapterUser


    }
}