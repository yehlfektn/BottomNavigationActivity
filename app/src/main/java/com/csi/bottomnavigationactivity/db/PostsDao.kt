package com.csi.bottomnavigationactivity.db

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PostsDao {
    @Query("SELECT * FROM posts_table ORDER BY id ASC")
    fun getAllPosts(): LiveData<List<Post>>

    @Query("SELECT * FROM posts_table WHERE id= :id")
    fun getPostById(id: Long): Flow<Post>

    @Delete
    suspend fun delete(post: Post)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(post: Post)

    @Update
    suspend fun update(post: Post)
}