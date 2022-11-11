package com.csi.bottomnavigationactivity.ui.profile

import android.app.Application
import androidx.lifecycle.*
import com.csi.bottomnavigationactivity.db.Note
import com.csi.bottomnavigationactivity.db.NoteDatabase
import com.csi.bottomnavigationactivity.db.Post
import com.csi.bottomnavigationactivity.db.PostsDao
import com.csi.bottomnavigationactivity.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProfileViewModel(
    application: Application
) : AndroidViewModel(application) {

   val allPosts: LiveData<List<Post>>
   private val repository: PostRepository

   init {
       val dao = NoteDatabase.getDatabase(application).getPostsDao()
       repository = PostRepository(dao)
       allPosts = repository.allPosts
   }

    fun deletePost(post: Post) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(post)
        }
    }

    fun updatePost(post: Post) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(post)
        }
    }

    fun getPostById(id: Long) = repository.get(id).asLiveData()

    fun isValidEntry(name: String, content: String): Boolean {
        return name.isNotBlank() && content.isNotBlank()
    }

    fun addPost(name: String, content: String) {
        val post = Post(
            title = name,
            content = content
        )

        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(post)
        }
    }
}