package com.csi.bottomnavigationactivity.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csi.bottomnavigationactivity.network.Character
import com.csi.bottomnavigationactivity.repository.BBRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import java.lang.RuntimeException

class DashboardViewModel(
    private val repository: BBRepository
) : ViewModel() {

    private val _charList = MutableLiveData<List<Character>>()
    val charList: LiveData<List<Character>>
        get() = _charList

    fun getChars() {
        viewModelScope.launch {
            repository.getChars().enqueue(object : Callback<List<Character>> {
                override fun onResponse(
                    call: Call<List<Character>>,
                    response: Response<List<Character>>
                ) {
                    _charList.value = response.body()
                    Timber.e("Characters: ${response.body()}")
                }

                override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                    throw RuntimeException()
                }
            })
        }
    }


    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}