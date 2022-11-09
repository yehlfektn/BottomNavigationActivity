package com.csi.bottomnavigationactivity.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PostsDao {
    @Query("SELECT * FROM postsTable ORDER BY id ASC")
    fun getAllPosts(): LiveData<List<Post>>

    @Delete
    suspend fun delete(post: Post)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(post: Post)

    @Update
    suspend fun update(post: Post)
}