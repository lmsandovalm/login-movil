package com.laurasando.aprendix_zulema.basedatos

class Constants {

    companion object {
        const val NOM_BD = "Bd_prueba"
        const val VERSION_BD = 2
        const val TABLA = "create table usuarios (nombre text, apellido text, telefono text, cedula text, contrasena text, nom_usuario text)"
        const val LOGIN = "Select name, contrasena from usuarios"
    }
}