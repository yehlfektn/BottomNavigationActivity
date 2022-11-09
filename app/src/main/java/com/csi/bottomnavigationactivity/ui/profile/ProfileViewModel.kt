package com.csi.bottomnavigationactivity.ui.profile

import android.app.Application
import androidx.lifecycle.*
import com.csi.bottomnavigationactivity.db.Note
import com.csi.bottomnavigationactivity.db.NoteDatabase
import com.csi.bottomnavigationactivity.db.Post
import com.csi.bottomnavigationactivity.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application) : AndroidViewModel(application) {

   val allPosts: LiveData<List<Post>>
   private val repository: PostRepository

   init {
       val dao = NoteDatabase.getDatabase(application).getPostsDao()
       repository = PostRepository(dao)
       allPosts = repository.allPosts
   }

    fun deleteNote(post: Post) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(post)
        }
    }

    fun updateNote(post: Post) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(post)
        }
    }

    fun addNote(post: Post) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(post)
        }
    }
}