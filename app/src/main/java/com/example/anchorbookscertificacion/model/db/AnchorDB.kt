package com.example.anchorbookscertificacion.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.anchorbookscertificacion.model.entities.BooksDetailEntity
import com.example.anchorbookscertificacion.model.entities.BooksEntity

@Database(entities = arrayOf(BooksEntity::class, BooksDetailEntity::class), version = 1)
abstract class AnchorDB  : RoomDatabase() {

    abstract fun dao(): AnchorDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AnchorDB? = null

        fun getDatabase(context: Context): AnchorDB {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnchorDB::class.java,
                    "database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}