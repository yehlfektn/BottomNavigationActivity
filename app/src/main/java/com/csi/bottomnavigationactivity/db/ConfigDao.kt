package com.csi.bottomnavigationactivity.db

import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
interface ConfigDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note : Note)

    @Delete
    suspend fun delete(note: Note)


    @Query("Select * from configTable order by id ASC")
    fun getAllCfg(): LiveData<List<Note>>

    @Update
    suspend fun update(note: Note)
}