package com.csi.bottomnavigationactivity.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class,Config::class],
    version = 2,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {
    abstract val configDao: ConfigDao
    abstract val notesDao: NotesDao
}
