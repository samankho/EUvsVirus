package com.example.corona.tracking.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.corona.tracking.database.dao.DbDatasetDao
import com.example.corona.tracking.database.entities.DbDataset

@Database(
    entities = [DbDataset::class],
    version = 1
)
//@TypeConverters(Converters::class)
internal abstract class AppDatabase : RoomDatabase() {

    internal abstract val datasetDao: DbDatasetDao

    companion object {

        private const val DB_NAME = "appDatabase.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also {
                INSTANCE = it
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DB_NAME
            ).build()
        }

    }
}