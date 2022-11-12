package com.csi.bottomnavigationactivity.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts_table")
data class Post(
    val title: String,
    val content: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)