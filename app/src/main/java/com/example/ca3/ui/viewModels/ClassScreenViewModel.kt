package com.example.ca3.ui.viewModels

import android.net.http.HttpEngine
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.ca3.model.SubjectClass
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.ca3.network.ClassInfoApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface ClassScreenUiState {
    data class Success(val classes: List<SubjectClass>) : ClassScreenUiState
    object Error : ClassScreenUiState
    object Loading : ClassScreenUiState
}


class ClassScreenViewModel : ViewModel() {
    var classScreenUiState by mutableStateOf<ClassScreenUiState>(ClassScreenUiState.Loading)
        private set


    init {
        Log.d("ClassScreenViewModel", "init called")
        getAllClasses()
        Log.d("ClassScreenViewModel", "getAllClasses called")
    }

    private fun getAllClasses() {
        viewModelScope.launch {
            classScreenUiState = ClassScreenUiState.Loading



            classScreenUiState = try {
                Log.d("ClassScreenViewModel", "try block for getClasses")
                val classes = ClassInfoApi.retrofitService.getClasses()

                ClassScreenUiState.Success(classes)
            } catch (e: IOException) {
                ClassScreenUiState.Error
            } catch (e: HttpException) {
                ClassScreenUiState.Error
            }
        }
    }
}

