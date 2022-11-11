package com.csi.bottomnavigationactivity.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.csi.bottomnavigationactivity.db.Post
import com.csi.bottomnavigationactivity.db.PostsDao
import kotlinx.coroutines.flow.Flow

class PostRepository(private val postsDao: PostsDao) {
    val allPosts: LiveData<List<Post>> = postsDao.getAllPosts()

    suspend fun insert(post: Post) {
        postsDao.insert(post)
    }

    suspend fun delete(post: Post) {
        postsDao.delete(post)
    }

    suspend fun update(post: Post) {
        postsDao.update(post)
    }

    fun get(id: Long): Flow<Post> {
        return postsDao.getPostById(id)
    }
}