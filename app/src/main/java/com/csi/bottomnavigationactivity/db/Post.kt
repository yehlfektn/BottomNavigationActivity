package com.csi.bottomnavigationactivity.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "postsTable")
data class Post(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val content: String
)