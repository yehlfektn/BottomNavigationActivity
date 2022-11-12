package com.csi.bottomnavigationactivity.di

import android.app.Application
import androidx.room.Room
import com.csi.bottomnavigationactivity.db.NoteDatabase
import com.csi.bottomnavigationactivity.db.NotesDao
import com.csi.bottomnavigationactivity.db.PostsDao
import com.csi.bottomnavigationactivity.repository.NoteRepository
import com.csi.bottomnavigationactivity.repository.PostRepository
import com.csi.bottomnavigationactivity.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single { NoteRepository(get()) }
    single { PostRepository(get()) }
    viewModel { HomeViewModel(get()) }
}


val databaseModule = module {
    fun provideDatabase(application: Application): NoteDatabase {
        return Room.databaseBuilder(application, NoteDatabase::class.java, "note_database")
            .build()
    }

    fun provideNotesDao(database: NoteDatabase): NotesDao {
        return database.getNotesDao()
    }

    fun providePostsDao(database: NoteDatabase): PostsDao {
        return database.getPostsDao()
    }

    single { provideDatabase(get()) }
    single { provideNotesDao(get()) }
    single { providePostsDao(get()) }
}