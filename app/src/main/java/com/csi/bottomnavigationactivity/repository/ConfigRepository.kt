package com.csi.bottomnavigationactivity.repository

import androidx.lifecycle.LiveData
import com.csi.bottomnavigationactivity.db.Config
import com.csi.bottomnavigationactivity.db.ConfigDao
import com.csi.bottomnavigationactivity.db.Note

class ConfigRepository(private val configDao:ConfigDao) {

    // on below line we are creating a variable for our list
    // and we are getting all the notes from our DAO class.
    val allCfg: LiveData<List<Config>> = configDao.getAllCfg()

    // on below line we are creating an insert method
    // for adding the note to our database.
    suspend fun insert(config: Config) {
        configDao.insert(config)
    }

    // on below line we are creating a delete method
    // for deleting our note from database.
    suspend fun delete(config: Config) {
        configDao.delete(config)
    }

    // on below line we are creating a update method for
    // updating our note from database.
    suspend fun update(config: Config) {
        configDao.update(config)
    }
}