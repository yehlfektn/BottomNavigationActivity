package com.csi.bottomnavigationactivity.repository

import androidx.lifecycle.LiveData
import com.csi.bottomnavigationactivity.db.Post
import com.csi.bottomnavigationactivity.db.PostsDao

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
}