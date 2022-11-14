package com.csi.bottomnavigationactivity.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "configTable")
class Config (
    val nameConfig: String,
    val descriptionConfig: String,
    val timeStamp: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)