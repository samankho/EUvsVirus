package com.example.corona.tracking.database.dao

import androidx.room.*
import com.example.corona.tracking.database.entities.DbDataset
import kotlinx.coroutines.flow.Flow

@Dao
internal interface DbDatasetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(datasets: DbDataset)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(datasets: Array<DbDataset>)

    @Update
    suspend fun update(vararg datasets: DbDataset)

    @Query("SELECT * FROM DbDataset WHERE id = :id")
    suspend fun get(id: Long): DbDataset?

    @Query("SELECT * FROM DbDataset")
    suspend fun getAll(): DbDataset?

    @Query("SELECT * FROM DbDataset WHERE id = :id")
    fun getAsFlow(id: Long): Flow<DbDataset>

    @Delete
    suspend fun delete(vararg datasets: DbDataset)
}