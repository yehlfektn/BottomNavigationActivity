package com.csi.bottomnavigationactivity.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class, Card::class],
    version = 2,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {
    abstract val notesDao: NotesDao
    abstract val cardsDao: CardsDao
}