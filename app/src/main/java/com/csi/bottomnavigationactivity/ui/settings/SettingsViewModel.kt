package com.csi.bottomnavigationactivity.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csi.bottomnavigationactivity.db.Config
import com.csi.bottomnavigationactivity.db.Note
import com.csi.bottomnavigationactivity.repository.ConfigRepository
import com.csi.bottomnavigationactivity.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val repository: ConfigRepository,
) : ViewModel() {

    val allCfg: LiveData<List<Config>> = repository.allCfg

    fun deleteConfig(config: Config) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(config)
        }
    }

    // on below line we are creating a new method for updating a note. In this we are
    // calling a update method from our repository to update our note.
    fun updateConfig(config: Config) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(config)
        }
    }

    // on below line we are creating a new method for adding a new note to our database
    // we are calling a method from our repository to add a new note.
    fun addConfig(config: Config) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(config)
        }
    }
}
