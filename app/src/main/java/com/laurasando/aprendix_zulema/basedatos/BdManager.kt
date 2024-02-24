package com.laurasando.aprendix_zulema.basedatos

import android.annotation.SuppressLint
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

    @SuppressLint("SuspiciousIndentation")
    fun inserData(nombre: String, apellido: String, telefono: String, cedula: String, contrasena: String, nomUsuario: String): Long {

        openBdWr()

        val  values = ContentValues()
        values.put("nombre", nombre)
        values.put("apellido", apellido)
        values.put("telefono", telefono)
        values.put("cedula", cedula)
        values.put("contrasena", contrasena)
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
                val telefono   = cursor.getString(telefonoIndex)
                val cedula   = cursor.getString(cedulaIndex)
                val contrasena   = cursor.getString(contraIndex)
                val nombreUsuario   = cursor.getString(nomusIndex)

                val usuario = Usuario(nombre, apellido, telefono, cedula, contrasena, nombreUsuario)

                usuarioList.add(usuario)
            } while (cursor.moveToNext())
        }
        return usuarioList
    }   fun login(nombre: String, contrasena: String): Boolean {
        openBdRd()

        val cursor: Cursor = bd.rawQuery("SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ?", arrayOf(nombre, contrasena))

        val result = cursor.count > 0

        cursor.close()
        return result
    }


}