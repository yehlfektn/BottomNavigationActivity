package com.csi.bottomnavigationactivity.db

import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
interface ConfigDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(config : Config)

    @Delete
    suspend fun delete(config: Config)


    @Query("Select * from configTable order by id ASC")
    fun getAllCfg(): LiveData<List<Config>>

    @Update
    suspend fun update(config: Config)
}