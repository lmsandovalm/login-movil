package com.laurasando.aprendix_zulema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.laurasando.aprendix_zulema.basedatos.BdManager

class Registro_usuarios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_usuarios)

        val nombreEdit = findViewById<EditText>(R.id.edt_nombre)
        val apellidoEdit = findViewById<EditText>(R.id.edt_apellido)
        val telefonoEdit = findViewById<EditText>(R.id.edt_telefono)
        val cedulaEdit = findViewById<EditText>(R.id.edt_cedula)
        val contraEdit = findViewById<EditText>(R.id.edt_regis_contra)
        val nomusEdit = findViewById<EditText>(R.id.edt_nomUsuario)
        val btnRegistrarse = findViewById<Button>(R.id.btn_guardarRegistro)
        val btnMostrar = findViewById<Button>(R.id.btn_mostrarDatos)


        btnRegistrarse.setOnClickListener{
            val nombre= nombreEdit.text.toString()
            val apellido= apellidoEdit.text.toString()
            val telefono= telefonoEdit.text.toString()
            val cedula= cedulaEdit.text.toString()
            val contrasena= contraEdit.text.toString()
            val nombreUsuario= nomusEdit.text.toString()

            val managerDb = BdManager(this)
            val resul = managerDb.inserData(nombre, apellido, telefono, cedula, contrasena, nombreUsuario )

            if (resul>0){
                Toast.makeText(this, "Datos Insertados" + resul, Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Ha ocurrido un problema" + resul, Toast.LENGTH_SHORT).show()
            }

            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

            btnMostrar.setOnClickListener {
                intent = Intent(this,Listado_usuarios::class.java)
                startActivity(intent)
            }



    }
}