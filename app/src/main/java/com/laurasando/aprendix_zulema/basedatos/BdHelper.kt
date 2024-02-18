package com.laurasando.aprendix_zulema.basedatos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BdHelper(
    context: Context?,
) : SQLiteOpenHelper(context, Constants.NOM_BD, null, Constants.VERSION_BD) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(Constants.TABLA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTs usuarios")
        onCreate(db)
    }
}