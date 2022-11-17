package com.csi.bottomnavigationactivity.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CardsDao {

    @Query("SELECT * FROM cards_table ORDER BY id ASC")
    fun getCards(): LiveData<List<Card>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(card: Card)

    @Delete
    suspend fun delete(card: Card)

    @Update
    suspend fun update(card: Card)
}