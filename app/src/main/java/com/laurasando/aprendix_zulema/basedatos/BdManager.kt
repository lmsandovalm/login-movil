package com.laurasando.aprendix_zulema.basedatos

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class BdManager(val context: Context) {

    lateinit var bd: SQLiteDatabase
    val  bdHelper = BdHelper(context)

    fun openBdWr(){
        bd = bdHelper.writableDatabase
    }

    fun openBdRd(){
        bd= bdHelper.readableDatabase
    }

    fun inserData(nombre: String, apellido: String, telefono: Int, cedula: Int, contrasena: Int, nomUsuario: String): Long {
        openBdWr()

        val  values = ContentValues()
        values.put("nombre", nombre)
        values.put("apellido", apellido)
        values.put("telefono", telefono)
        values.put("cedula", cedula)
        values.put("contraseña", contrasena)
        values.put("nom_usuario", nomUsuario)

        val resul = bd.insert("usuarios", null, values)
        return resul
    }

    fun listData(): ArrayList<Usuario>{
        val usuarioList= ArrayList<Usuario>()
        openBdRd()
        val cursor:Cursor= bd.rawQuery("select *from usuarios", null)

        if (cursor.moveToFirst()){
            do {
                val nombreIndex = cursor.getColumnIndex("nombre")
                val apellidoIndex = cursor.getColumnIndex("apellido")
                val telefonoIndex = cursor.getColumnIndex("telefono")
                val cedulaIndex = cursor.getColumnIndex("cedula")
                val contraIndex = cursor.getColumnIndex("contraseña")
                val nomusIndex = cursor.getColumnIndex("nom_usuario")
                val nombre = cursor.getString(nombreIndex)
                val apellido   = cursor.getString(apellidoIndex)
                val telefono   = cursor.getInt(telefonoIndex)
                val cedula   = cursor.getInt(cedulaIndex)
                val contrasena   = cursor.getInt(contraIndex)
                val nombreUsuario   = cursor.getString(nomusIndex)
                val usuario = Usuario(nombre, apellido, telefono, cedula, contrasena, nombreUsuario)
                usuarioList.add(usuario)
            } while (cursor.moveToNext())
        }
        return usuarioList
    }


}