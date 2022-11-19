package com.csi.bottomnavigationactivity.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards_table")
class Card(
    val question: String,
    val answer: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
)